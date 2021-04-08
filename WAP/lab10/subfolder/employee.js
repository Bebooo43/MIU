import {Person} from "./person.js"

export class Employee extends Person{

    //private fields declarations (Encapsulation)
    #salary = 0.0;
    #hireDate = null;

    constructor(name, dateOfBirth, salary, hireDate){
        super(name,dateOfBirth);
        this.#salary = salary;
        this.#hireDate = hireDate;
    }

    //GETs and SETs
    get salary(){return this.#salary;}
    get hireDate(){return this.#hireDate;}

    set salary(newSalary){this.#salary = newSalary;}
    set hireDate(newHireDate){this.#hireDate = newHireDate;}

    doJob(jobTitle) { 
        console.log(`${super.name} is a ${jobTitle} who earns ${salaryFormatter.format(this.salary)}`);
    };
}

const salaryFormatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2
});