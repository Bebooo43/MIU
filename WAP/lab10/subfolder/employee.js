import {Person} from "./person.js"

export class Employee extends Person{
    constructor(name, dateOfBirth, salary, hireDate){
        super(name,dateOfBirth);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    //GETs and SETs
    get salary(){return this._salary;}
    get hireDate(){return this._hireDate;}

    set salary(newSalary){this._salary = newSalary;}
    set hireDate(newHireDate){this._hireDate = newHireDate;}
}

const salaryFormatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2
});

Employee.prototype.doJob = function(jobTitle) {console.log(`${this.name} is a ${jobTitle} who earns ${salaryFormatter.format(this.salary)}`);};