/**
 * Fetches and loads list of books data to html-table-tbody
 * @returns {void}
 */
 function getBooks() { 
    fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/list")
    .then((response) => {
        if(response.ok) {    
            return response.json();
        } else {
            return Promise.reject({ status: response.status, statusText: response.statusText });
        }
    })
    .then(books => {
        let content = "";
        books.forEach(function(book, i) {
        content += `
                <tr>
                <th scope="row">${i+1}.</th>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",minimumFractionDigits:2}).format(book.overdueFee)}</td>
                <td>${book.publisher}</td>
                <td>${book.datePublished}</td>
                </tr>
            `;
        });
        document.querySelector("#tbody").innerHTML = content;
    })
    .catch(err => {
        console.log("Error message:", err.statusText);
        const msg = "<tr><td colspan='8'><p style='color:#ff0000;'>We are sorry. The elibrary books data service is unavailable. Please try again later</p></td></tr>";
        document.getElementById("divBooksList").innerHTML = msg;
    });
}
getBooks();

const bookForm = document.getElementById("bookForm");
const closeButton = document.getElementById("closeModalButton");
const saveButton = document.getElementById("saveModalButton");

closeButton.addEventListener("click", function(event) {
    bookForm.reset();
});

saveButton.addEventListener("click", function(event) {
    //Validade required fields modal (and keep values)

    event.preventDefault();

    const title = document.getElementById("title").value;
    const isbn = document.getElementById("isbn").value;
    const overdueFee = document.getElementById("overdue-fee").value;
    const publisher = document.getElementById("publisher").value;
    const datePublished = document.getElementById("date-published").value;

    // Add New Book data
    const newBookData = {
        "title": title,
        "isbn": isbn,
        "overdueFee": overdueFee,
        "publisher": publisher,
        "datePublished": datePublished
    };

    fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/add", {
        method: "post",
        body: JSON.stringify(newBookData),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(response) {
        return response.json();
    }).then(function (jsonResponseData) {  
        bookForm.reset();
        getBooks();

        document.getElementById("book-added-alert").className += ' show';
    }).catch(function(error) {
        console.error(error);
    });
});

//based on kalu github: https://github.com/obkalu/elibrary-spa/blob/master/js/elibrary.js