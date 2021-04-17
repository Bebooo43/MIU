var selectedRow = null
var patientTable = document.getElementById("patientTable").getElementsByTagName('tbody')[0];

var initialArrayGlobal = loadData();

function loadData() {
    let patient1 = { "patientId": 1, "nameId": "John", "midNameId": "M", "lastNameId": "Santiago","dateBirthId": new Date('1992-02-03'),"departmentId": "D 1","outPatient": "Yes"};
    let patient2 = { "patientId": 2, "nameId": "Boaz", "midNameId": "M", "lastNameId": "Boaz","dateBirthId": new Date('1985-02-03'),"departmentId": "D 2","outPatient": "No"};
    let patient3 = { "patientId": 3, "nameId": "Berhane", "midNameId": "M", "lastNameId": "Berhane","dateBirthId": new Date('1950-02-03'),"departmentId": "D 3","outPatient": "Yes"};
    let patient4 = { "patientId": 4, "nameId": "Gedeon", "midNameId": "M", "lastNameId": "Gedeon","dateBirthId": new Date('1960-02-03'),"departmentId": "D 4","outPatient": "No"};
    let patient5 = { "patientId": 5, "nameId": "Obinna", "midNameId": "M", "lastNameId": "Obinna","dateBirthId": new Date('1945-02-03'),"departmentId": "D 5","outPatient": "Yes"};

    let initialArray = [patient1,patient2,patient3,patient4,patient5];
    initialArray.forEach(element => {
        insertNewRecord(element);
    });
    return initialArray;
}


const outPatientOnlyCheck = document.getElementById("outPatientOnlyCheck");
outPatientOnlyCheck.addEventListener('change', function(event) {
    
    let filteredArray = initialArrayGlobal;
    clearTable();

    if(this.checked) 
        filteredArray = filteredArray.filter(e => e.outPatient === "Yes");
    
    filteredArray.forEach(element => {
        insertNewRecord(element);
    });
    
});

const patientForm = document.getElementById("patientForm");
patientForm.addEventListener('submit', function(event) {
    event.preventDefault();

    var formData = readFormData();
    if (selectedRow == null)
        insertNewRecord(formData);
    else
        updateRecord(formData);
    resetForm();
});

function readFormData() {
    var formData = {};

    formData["patientId"] = document.getElementById("patientId").value;
    formData["nameId"] = document.getElementById("nameId").value;
    formData["midNameId"] = document.getElementById("midNameId").value;
    formData["lastNameId"] = document.getElementById("lastNameId").value;
    formData["dateBirthId"] = document.getElementById("dateBirthId").value;
    formData["departmentId"] = document.getElementById("departmentId").value;
    formData["outPatient"] = document.querySelector('input[name="outPatient"]:checked').value;

    return formData;
}

function insertNewRecord(data) {
    var newRow = patientTable.insertRow(patientTable.length);//-1 works too
    
    const cell1 = newRow.insertCell(0);
    cell1.innerText = data.patientId;
    const cell2 = newRow.insertCell(1);
    cell2.innerText = data.nameId;
    const cell3 = newRow.insertCell(2);
    cell3.innerText = data.midNameId;
    const cell4 = newRow.insertCell(3);
    cell4.innerText = data.lastNameId;
    const cell5 = newRow.insertCell(4);
    cell5.innerText = data.dateBirthId;
    const cell6 = newRow.insertCell(5);
    cell6.innerText = data.departmentId;
    const cell7 = newRow.insertCell(6);
    cell7.innerText = data.outPatient;
    const cell8 = newRow.insertCell(7);
    cell8.innerHTML = `<a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
    document.getElementById("patientId").value = '';
    document.getElementById("nameId").value = '';
    document.getElementById("midNameId").value = '';
    document.getElementById("lastNameId").value = '';
    document.getElementById("dateBirthId").value = '';
    document.getElementById("departmentId").value = '';

    if(document.querySelector('input[name="outPatient"]:checked') != null)
        document.querySelector('input[name="outPatient"]:checked').value = '';
    selectedRow = null;
}

function onDelete(a) {
    if (confirm('Are you sure to delete this record ?')) {
        let row = a.parentElement.parentElement;//a -> td -> tr
        document.getElementById("patientTable").deleteRow(row.rowIndex);
        resetForm();
    }
}

function clearTable(){
    let table = document.getElementById("patientTable");
    for (let i = table.rows.length-1; i >0; i--) {
        table.deleteRow(i);
    }
}
