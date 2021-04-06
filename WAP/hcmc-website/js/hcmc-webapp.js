/**
 * hcmc-webapp.js
 * 
 * @author O. Kalu
 * @since 2020-05-03
 */

$(document).ready(function() {
    "use strict";
    const patients = [];
    function Patient(patientIdNo, firstName, middleInitials, lastName, 
        dateOfBirth, department, isOutPatient) {
            this.patientIdNo = patientIdNo;
            this.firstName = firstName;
            this.middleInitials = middleInitials;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.department = department;
            this.isOutPatient = isOutPatient;
    }

    Patient.prototype.toString = function() {
        return `{patientIdNo: ${this.patientIdNo}, firstName: ${this.firstName}, 
            middleInitial: ${this.middleInitials}, lastName: ${this.lastName}, 
            dateOfBirth: ${this.dateOfBirth}, department: ${this.department}, 
            isOutPatient: ${this.isOutPatient}}`;
    };

    $("#patientRegistrationForm").submit(
        event => {
            event.preventDefault();
            const patientIdNo = $("#patientIdNumber").val();
            const firstName = $("#firstName").val();
            const middleInitials = $("#middleInitials").val();
            const lastName = $("#lastName").val();
            const dateOfBirth = $("#dateOfBirth").val();
            const department = $("#ddlDepartment").val();
            const isOutPatient = $("input[name='radioIsOutPatient']:checked").val();
            
            const newPatient = new Patient(patientIdNo, firstName, middleInitials, lastName, dateOfBirth, department, isOutPatient);
            patients.push(newPatient);
            console.log(newPatient.toString());

            let newDataRow = `<tr><td>${patientIdNo}</td><td>${firstName}</td><td>${middleInitials}</td><td>${lastName}</td><td>${dateOfBirth}</td><td>${department}</td><td>${isOutPatient}</td></tr>`; 
            $("#tbodyPatientsList").append(newDataRow);

            $("#patientIdNumber").val("");
            $("#firstName").val("");
            $("#middleInitials").val("");
            $("#lastName").val("");
            $("#dateOfBirth").val("");
            $("#ddlDepartment").val("");
            $("#radioIsOutPatientYes").prop("checked", false);
            $("#radioIsOutPatientNo").prop("checked", false);
            $("#patientIdNumber").focus();
        }
    );

    const chkElderlyPatients = document.querySelector("#chkElderlyPatients");
    chkElderlyPatients.addEventListener("change", (event) => {
        $("#tbodyPatientsList").empty();
        if(event.target.checked) {
            // filter patients array for elderly ones
            patients.filter(p => isElderlyPatient(p))
                .forEach(p => {
                    let dataRow = `<tr><td>${p.patientIdNo}</td><td>${p.firstName}</td><td>${p.middleInitials}</td><td>${p.lastName}</td><td>${p.dateOfBirth}</td><td>${p.department}</td><td>${p.isOutPatient}</td></tr>`; 
                    $("#tbodyPatientsList").append(dataRow);
                });
        } else {
            $("#tbodyPatientsList").empty();
            // re-display all Patients in array
            patients.forEach(p => {
                let dataRow = `<tr><td>${p.patientIdNo}</td><td>${p.firstName}</td><td>${p.middleInitials}</td><td>${p.lastName}</td><td>${p.dateOfBirth}</td><td>${p.department}</td><td>${p.isOutPatient}</td></tr>`; 
                $("#tbodyPatientsList").append(dataRow);
            })
        }
    });

    const isElderlyPatient = function(patient) {
        const todaysDate = new Date();
        //const strTimeOfBirth = "T00:00:00.000+06:00";
        const strYearOfBirth = patient.dateOfBirth.substr(0, 4);
        const nMonthOfBirth = parseInt(patient.dateOfBirth.substr(5, 2));
        const nDateOfMonthBirth = parseInt(patient.dateOfBirth.substr(8, 2)); 
        const strDateOfBirth = `${strYearOfBirth}-${nMonthOfBirth}-${nDateOfMonthBirth}`; //${strTimeOfBirth}`;
        const patientsBirthDate = new Date(strDateOfBirth);
        let age = (todaysDate.getFullYear()) - (patientsBirthDate.getFullYear());
        const monthDiff = todaysDate.getMonth() - patientsBirthDate.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && todaysDate.getDate() < patientsBirthDate.getDate())) {
            age--;
        }
        return age >= 65;
    }

});