
/* 
#Without JQuery

 const productForm = document.getElementById("productForm");
 productForm.addEventListener("submit", function(event){ 
    event.preventDefault();
    const pnumber = document.getElementById("pnumber").value;
    const qtsStock = document.getElementById("qtsStock").value;
    const pname = document.getElementById("pname").value;
    const supplier = document.getElementById("supplier").value;
    const unitPrice = document.getElementById("unitPrice").value;
    const dateSupplied = document.getElementById("dateSupplied").value;

    const stringForm = "Number: "+pnumber+", Qts Stock: "+qtsStock+", Name: "+pname+
        ", Supplier: "+supplier+", Unit Price: "+unitPrice+", Date Supplied: "+dateSupplied;
    
    alert(stringForm);
    
    let block = document.getElementById("block");
    block.innerText = stringForm;
});*/

$("#productForm").submit(function(event){ 
    event.preventDefault();
    const pnumber = $("#pnumber").val();
    const qtsStock = $("#qtsStock").val();
    const pname = $("#pname").val();
    const supplier = $("#supplier").val();
    const unitPrice = $("#unitPrice").val();
    const dateSupplied = $("#dateSupplied").val();

    const stringForm = "Number: "+pnumber+", Qts Stock: "+qtsStock+", Name: "+pname+
        ", Supplier: "+supplier+", Unit Price: "+unitPrice+", Date Supplied: "+dateSupplied;
    
    $("#block").text(stringForm);
 });