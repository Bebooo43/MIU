
 const productSubmitBtn = document.getElementById("productSubmitBtn");
 productSubmitBtn.addEventListener("click", function(){ 
    const pnumber = document.getElementById("pnumber").value;
    const qtsStock = document.getElementById("qtsStock").value;
    const pname = document.getElementById("pname").value;
    const supplier = document.getElementById("supplier").value;
    const unitPrice = document.getElementById("unitPrice").value;
    const dateSupplied = document.getElementById("dateSupplied").value;


    alert("Number: "+pnumber+", Qts Stock: "+qtsStock+", Name: "+pname+
        ", Supplier: "+supplier+", Unit Price: "+unitPrice+", Date Supplied: "+dateSupplied);
 });