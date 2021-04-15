/* eslint-disable id-length */
/* eslint-disable require-jsdoc */
/**
 * @filename elibrary.js
 * 
 * @author O. Kalu
 * @since 2019-12-15
 * @lastmodified 2019-12-17
 */

 "use strict";

 (function() {
    // declare vars for page-contents
    let HOME_PAGE_CONTENT; 
    let ABOUT_PAGE_CONTENT;
    let VIRTUALTOUR_PAGE_CONTENT; 
    let BOOKSLIST_PAGE_INITIAL_CONTENT;

    setupPageContents();

    /**
     * Sets up the content for each page
     * @returns {void} 
     */
    function setupPageContents() {
        HOME_PAGE_CONTENT = `
            <h3>Welcome to the eLibrary<sup>&reg;</sup></h3>
            <hr/>
            <div style="font-size: 1em">
                <img src="images/banner1.png"/><br/><br/>
                <p>We are a top-flight, fully-digitized library.
                    Find out more about us and
                    and learn how we can serve you with a widest variety of books and lots of other
                    digital content, all for your education as well as your entertainment.
                    You can also take a virtual tour,
                    of our world-class facilities and be amazed at all what we have in stock
                    for you, your family and friends.</p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text
                    ever since the 1500s, when an unknown printer took a galley of type
                    and scrambled it to make a type specimen book. It has survived not
                    only five centuries.</p>
                <p>Already have access as a Member, Librarian or System Administrator? Then, simply Sign-In
                    to access the full range of services available to you, based on your role and access rights.</p>
            </div>            
        `;
        ABOUT_PAGE_CONTENT = `
            <h3>About the eLibrary<sup>&reg;</sup></h3>
            <hr/>
            <div style="font-size: 1em">
                <p>We are your premier digital library. Our collection has the widest variety of books and lots of other
                    digital content, for your education as well as your entertainment.
                    You can take a virtual tour,
                    of our world-class facilities and be amazed at all what we have in stock
                    for you, your family and friends.</p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text
                    ever since the 1500s, when an unknown printer took a galley of type
                    and scrambled it to make a type specimen book. It has survived not
                    only five centuries.</p>
            </div>        
        `;
        VIRTUALTOUR_PAGE_CONTENT = `
            <h3>Virtual Tour of the eLibrary<sup>&reg;</sup></h3>
            <hr/>
            <div style="font-size: 1em">
                <p>Panoramic views and knowledge fountains</p>
                <img style="width: 100%; height: 135px;" src="images/panoramic.png"/>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>Already have access as a Member, Librarian or System Administrator? Then, simply <a href="#">Sign-In</a>
                    to access the full range of services available to you, based on your role and access rights.
                </p>
            </div>            
        `;
        BOOKSLIST_PAGE_INITIAL_CONTENT = `
            <div class="row" style="padding-bottom:1em;">
                <div class="col-md-4">
                    <span style="font-size: 2em; color: #32a5e7;">Books in our Collection</span>
                </div>
                <div class="col-md-4">
                    <span id="alertMessageBox" style="display:none;float:none;margin-left:0em;" class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Book successfully deleted!</strong>
                    </span>
                </div>            
                <div class="col-md-4">
                    <span style="float:right;">
                        <a data-toggle="modal" data-modalopenername="addnewbook" class="btn btn-outline-success btn-lg" href="#eLibraryAppBookFormModal">Add New Book</a>
                    </span>
                </div>
            </div>
            <!-- <p>&nbsp;</p> -->
            <div id="divBooksList" style="font-size: 1em">
                <table id="booksTable" class="table table-striped">
                    <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Book Title</th>
                    <th scope="col">Overdue Fee</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">Date Published</th>
                    <th scope="col">&nbsp;</th>
                    <th scope="col">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <tr><td style="text-align:center;" colspan="8">Loading...<br/>Please wait</td></tr>
                    </tbody>
                </table>
            </div>       
        `;        
    }

    /**
     * Displays homepage content
     * @returns {void}
     */
    function showHomePage() {
        document.getElementById("pageContentOutlet").innerHTML = HOME_PAGE_CONTENT;
    }

    /**
     * Displays aboutUs Page content
     * @returns {void}
     */
    function showAboutUsPage() {
        document.getElementById("pageContentOutlet").innerHTML = ABOUT_PAGE_CONTENT;
    }

    /**
     * Displays Virtual Tour page content
     * @returns {void}
     */
    function showVirtualTourPage() {
        document.getElementById("pageContentOutlet").innerHTML = VIRTUALTOUR_PAGE_CONTENT;
    }

    /**
     * Displays BooksList Page content
     * @returns {void}
     */
    function showBooksListPage() {
        document.getElementById("pageContentOutlet").innerHTML = BOOKSLIST_PAGE_INITIAL_CONTENT;
        getBooks();
    }

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
                    <td><a href="#eLibraryAppBookFormModal" data-toggle="modal" data-bookid="${book.bookId}" data-modalopenername="edit">Edit</a></td>
                    <td><a data-toggle="modal" data-bookid="${book.bookId}" data-bookisbn="${book.isbn}" data-booktitle="${book.title}" href="#eLibraryAppConfirmDeleteBookModal">Delete</a></td>
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

    const app = {
        pages: ["home", "aboutus", "virtualtour", "bookslist"],
        init: function() {
            document.querySelectorAll(".nav-link").forEach(navLink => {
                navLink.addEventListener("click", app.nav);
            });
            document.querySelectorAll(".navbar-brand").forEach(navBarBrand => {
                navBarBrand.addEventListener("click", app.nav);
            });
            history.replaceState({}, "Home", "#home");
            window.addEventListener("popstate", app.popState);
            showHomePage();
        },
        nav: function(event) {
            event.preventDefault();
            let currPage = event.target.getAttribute("data-target");
            history.pushState({}, currPage, `#${currPage}`);
            if(currPage === "home") {
                showHomePage();
            }
            if(currPage === "aboutus") {
                showAboutUsPage();
            }
            if(currPage === "virtualtour") {
                showVirtualTourPage();
            }
            if(currPage === "bookslist") {
                showBooksListPage();
            }
        },
        popState: function(event) {
            let pagename = location.hash.replace("#", "");
            if(pagename === "home") {
                showHomePage();
            }
            if(pagename === "aboutus") {
                showAboutUsPage();
            }
            if(pagename === "virtualtour") {
                showVirtualTourPage();
            }
            if(pagename === "bookslist") {
                showBooksListPage();
            }
        }
    };

    $(document).ready(function() {
        $("#eLibraryAppBookFormModal").on("show.bs.modal", function(event) {
            // remove any previous event-listeners from bookForm
            $("#bookForm").off();
            const opener = $(event.relatedTarget);
            const openername = opener.data("modalopenername");

            if(openername === "edit") {
                $("#elibraryAppBookFormModalCenterTitle").text("Edit Book Form");
                const bookId = opener.data("bookid");                
                // fetch and present book data
                fetchAndDisplayBookData(bookId);                
            } else {
                $("#elibraryAppBookFormModalCenterTitle").text("New Book Form");
            }
            $("#opname").val(openername);

            $("#bookForm").on("submit", function(evt) {
                evt.preventDefault();

                const opname = $("#opname").val();
                const bookId = $("#txtBookId").val();
                const isbn = $("#isbn").val();
                const title = $("#title").val();
                const overdueFee = parseFloat($("#overdueFee").val());
                const publisher = $("#publisher").val();
                const datePublished = $("#datePublished").val();

                if(opname === "addnewbook") {
                    // Add New Book data
                    const newBookData = {
                        "isbn": isbn,
                        "title": title,
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
                        console.log(jsonResponseData);  
                        clearBookForm(); 
                        getBooks();
                        $("#modalBookFormStrongAlertText").text("Book successfully added!");
                        $("#modalBookFormAlertMessageBox").removeClass("alert-danger");
                        $("#modalBookFormAlertMessageBox").addClass("alert-success");
                    }).catch(function(error) {
                        console.error(error);
                        $("#modalBookFormAlertMessageBox").removeClass("alert-success");
                        $("#modalBookFormAlertMessageBox").addClass("alert-danger");
                    });
                } else if(opname === "edit") {
                    // Update edited Book data
                    const editedBookData = {
                        "bookId": bookId,
                        "isbn": isbn,
                        "title": title,
                        "overdueFee": overdueFee,
                        "publisher": publisher,
                        "datePublished": datePublished
                    };
        
                    fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/update/"+bookId, {
                        method: "put",
                        body: JSON.stringify(editedBookData),
                        headers: {
                            "Content-Type": "application/json"
                        }
                    }).then(function(response) {
                        return response.json();
                    }).then(function (jsonResponseData) {
                        console.log(jsonResponseData);   
                        clearBookForm(); 
                        getBooks();
                        $("#modalBookFormStrongAlertText").text("Book successfully saved!");
                        $("#modalBookFormAlertMessageBox").removeClass("alert-danger");
                        $("#modalBookFormAlertMessageBox").addClass("alert-success");
                    }).catch(function(error) {
                        console.error(error);
                        $("#modalBookFormAlertMessageBox").removeClass("alert-success");
                        $("#modalBookFormAlertMessageBox").addClass("alert-danger");
                    });
                }

                document.getElementById("modalBookFormAlertMessageBox").style.display = "inline-block";
                setTimeout(hideAlertMessageBox, 5000);
            });
        });

        // Delete Modal
        $("#eLibraryAppConfirmDeleteBookModal").on("show.bs.modal", function(event){
            const deleteLink = $(event.relatedTarget);
            const bookId = deleteLink.data("bookid");
            const bookISBN = deleteLink.data("bookisbn");
            const bookTitle = deleteLink.data("booktitle");
            const alertMessageBox = document.getElementById("alertMessageBox");
            const theModalDialog = $(this);
            theModalDialog.find("#deleteModalBookISBN").text("ISBN:  " + bookISBN);
            theModalDialog.find("#deleteModalBookTitle").text("Book Title:  " + bookTitle);
            // Event-handler for the 'Yes' button click event
            $("#deleteModalBtnYes").on("click", function(evt) {
                fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/delete/"+bookId, {
                    method: "delete"
                }).then(function(response) {                    
                    console.log(`Successfully deleted Book with bookId: ${bookId}`);
                    // Dismiss modal dialog
                    $("#eLibraryAppConfirmDeleteBookModal").modal("hide");
                    getBooks();
                    alertMessageBox.style.display = "inline-block";
                }).catch(function(error) {
                    console.error(error);
                    alertMessageBox.classList.remove("alert-success");
                    alertMessageBox.classList.add("alert-danger");
                    alertMessageBox.style.display = "inline-block";
                });
              });
            });
    });

    function hideAlertMessageBox() {
        document.getElementById("modalBookFormAlertMessageBox").style.display = "none";
    }

    function clearBookForm() {
        $("#isbn").val("");     
        $("#title").val("");   
        $("#overdueFee").val("0.00");
        $("#publisher").val("");
        $("#datePublished").val("");   
     }

    function fetchAndDisplayBookData(bookId) {
        // fetch the book data by bookId
        fetch('https://elibraryrestapi.herokuapp.com/elibrary/api/book/get/'+bookId)
            .then((response) => {
                if(response.ok) {    
                    return response.json();
                } else {
                    return Promise.reject({ status: response.status, statusText: response.statusText });
                }
                })
            .then(book => {
                $("#txtBookId").val(book.bookId);
                $("#isbn").val(book.isbn);
                $("#title").val(book.title);
                $("#overdueFee").val(book.overdueFee.toFixed(2));
                $("#publisher").val(book.publisher);
                $("#datePublished").val(book.datePublished);
            })
            .catch(err => {
                console.log("Error message: ", err.statusText);
                // TODO display error in alertMsgBox
            });            
    }

    document.addEventListener("DOMContentLoaded", app.init);

})();