"use strict";
var selectedRow = null
const bankAccountForm = $("#bankAccountForm");
const bankAccountTable = $('#bankAccountTable');
$("#numberAccount").focus();

function readFormData() {
    var formData = {};
    formData["idAccount"] = $("#idAccount").val();
    formData["numberAccount"] = $("#numberAccount").val();
    formData["cName"] = $("#cName").val();
    formData["typeAccount"] = $("#typeAccount").val();
    return formData;
}

bankAccountForm.submit(function(event) {
    event.preventDefault();

    const formData = readFormData();
    if (selectedRow == null)
        addNewAccountDataRow(formData);
    else
        updateAccountRecord(formData);
    //clean form
    resetForm();
    $("#numberAccount").focus();
});

 //Solution using table provided by kalu 
 const addNewAccountDataRow = function(data) {
    bankAccountTable.append('<tr>'+
        '<td>' + $('#bankAccountTable tr').length + '</td>'+
        '<td>' + data.numberAccount + '</td>'+
        '<td>' + data.cName + '</td>'+
        '<td id="tdTypeAccount">' + data.typeAccount + '</td>'+
        '<td> <a onClick="onEdit(this)"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp&nbsp<a onClick="onDelete(this)"><span class="glyphicon glyphicon-trash"></span></a>` </td>'+
    '</tr>');
    
    selectedRow == null;
}

function onDelete(a) {
    if (confirm('Are you sure to delete this record ?')) {
        $(a).closest('tr').remove();
        resetForm();
    }
}

function onEdit(a) {
    selectedRow = $(a).parent().closest('tr');
    $("#idAccount").val($(selectedRow.children()[0]).text());
    $("#numberAccount").val($(selectedRow.children()[1]).text());
    $("#cName").val($(selectedRow.children()[2]).text());
    $("#typeAccount").val($(selectedRow.children()[3]).text());

    $("#accountSubmitButton").html('Update Account').button('refresh');

}

function updateAccountRecord(formData) {  
    $(selectedRow.children()[0]).text(formData.idAccount);
    $(selectedRow.children()[1]).text(formData.numberAccount);
    $(selectedRow.children()[2]).text(formData.cName);
    $(selectedRow.children()[3]).text(formData.typeAccount);
    $("#accountSubmitButton").html('Create New Account').button('refresh');
}

function resetForm() {
    bankAccountForm[0].reset();
    selectedRow = null;
}

$("#savingsOnly").change(function(event) {
    if(this.checked){ 
        $("#bankAccountTable tbody > tr").filter(function() {
            $(this).toggle($(this).find('#tdTypeAccount').text().toLowerCase().indexOf("savings") > -1)
        });
    }else{
        $("#bankAccountTable tbody > tr").show();
    }
});

/**
    #Plain-vanilla DOM Web API
 
const bankAccountForm = document.getElementById("bankAccountForm");

function readFormData() {
    var formData = {};
    formData["idAccount"] = document.getElementById("idAccount").value;
    formData["numberAccount"] = document.getElementById("numberAccount").value;
    formData["cName"] = document.getElementById("cName").value;
    formData["typeAccount"] = document.getElementById("typeAccount").value;
    return formData;
}

bankAccountForm.addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = readFormData();
    if (selectedRow == null)
        addNewAccountDataRow(formData);
    else
        updateAccountRecord(formData);

    //clean form
    resetForm();
});

 //Solution using table provided by kalu 
 const addNewAccountDataRow = function(data) {
    const tblAccounts = document.querySelector("#bankAccountTable");
    const newRow = tblAccounts.insertRow(-1);

    //inserting ID on column 1
    const newCellRowId = newRow.insertCell(0);
    const strNewRowId = document.createTextNode(`${tblAccounts.rows.length-1}.`);//-1 because I just inserted before
    newCellRowId.appendChild(strNewRowId);
    
    //inserting accountNo on column 2
    const newCellAccountNo = newRow.insertCell(1);
    const strNewRowAccountNo = document.createTextNode(`${data.numberAccount}`);
    newCellAccountNo.appendChild(strNewRowAccountNo);
    
    //inserting customer name on column 3
    const newCellCustomerName = newRow.insertCell(2);
    const strNewRowCustomerName = document.createTextNode(`${data.cName}`);
    newCellCustomerName.appendChild(strNewRowCustomerName);
    
    //inserting type Account on column 4
    const newCellAccountType = newRow.insertCell(3);
    const strNewRowAccountType = document.createTextNode(`${data.typeAccount}`);
    newCellAccountType.appendChild(strNewRowAccountType);

    //inserting delete button on column 5
    const newCellDeleteButton = newRow.insertCell(4);
    newCellDeleteButton.innerHTML = `<a onClick="onEdit(this)"><span class="glyphicon glyphicon-pencil"></span></a>
                                     <a onClick="onDelete(this)"><span class="glyphicon glyphicon-trash"></span></a>`;
    
    selectedRow == null;
}

function onDelete(a) {
    if (confirm('Are you sure to delete this record ?')) {
        let row = a.parentElement.parentElement;//a -> td -> tr
        document.getElementById("bankAccountTable").deleteRow(row.rowIndex);
        resetForm();
    }
}

function onEdit(a) {
    selectedRow = a.parentElement.parentElement;
    document.getElementById("idAccount").value = selectedRow.cells[0].innerText;
    document.getElementById("numberAccount").value = selectedRow.cells[1].innerText;
    document.getElementById("cName").value = selectedRow.cells[2].innerText;
    document.getElementById("typeAccount").value = selectedRow.cells[3].innerText;
}


function updateAccountRecord(formData) {
    selectedRow.cells[0].innerText = formData.idAccount;
    selectedRow.cells[1].innerText = formData.numberAccount;
    selectedRow.cells[2].innerText = formData.cName;
    selectedRow.cells[3].innerText = formData.typeAccount;
}

function resetForm() {
    bankAccountForm.reset();
    selectedRow = null;
}

    /** 
     * Adding in a UL
    const list = document.getElementById("customerAccountList");
    const newValue = document.createElement("li");
    newValue.classList.add("list-group-item");
    newValue.appendChild(document.createTextNode(numberAccount +" | "+cName+" | "+typeAccount));
    list.appendChild(newValue);
*/
    