"use strict";

//Question 1
console.log('#Question 1  \n');
const person = {
    name:"",
    dateOfBirth :null,
    getName: function() {
        return this.name;},
    setName: function (newName) {this.name = newName;},
    getDateOfBirth: function() {
        return this.dateOfBirth.getFullYear()+"-"+(this.dateOfBirth.getMonth()+1)+"-"+this.dateOfBirth.getDate();
    },
    setDateOfBirth: function (newDateOfBirth) {this.dateOfBirth = newDateOfBirth;},
    toString: function() {
        return `The person’s name is ${this.name}\n${this.name} was born on `+this.getDateOfBirth();
    }
}

let john = Object.create(person);
john.setName("John");
john.setDateOfBirth(new Date(1998, 11,10));
//String template literal versus string concatenation
console.log(john.toString());


//Question 2
console.log('#Question 2  \n');

const salaryFormatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2
});

//Option 1
const employee = Object.create(person);
employee.salary = 0;
employee.hireDate = null;
employee.doJob = function(jobTitle) { //WARNING if you use arrow function this will be window
    console.log(`${this.name} is a ${jobTitle} who earns ${salaryFormatter.format(this.salary)}`); 
}

//Option 2
const employee2 = Object.create(person,{
    salary:{
        writable: true,
        configurable: true,
        enumerable: true,
        value: 0.0
    },
    hireDate:{
        writable: true,
        configurable: true,
        enumerable: true,
        value: null
    }
});
employee2.doJob = function(jobTitle){//WARNING if you use arrow function this will be window
    console.log(`${this.name} is a ${jobTitle} who earns ${salaryFormatter.format(this.salary)}`); 
}

const anna = Object.create(employee);
anna.setName("Anna");
anna.salary = 249995.50;
anna.doJob('Programmer');

//Question 3
console.log('#Question 3  \n');

function Person(_name, _dateOfBirth) {
    this.name = _name;
    this.dateOfBirth = _dateOfBirth;
}
Person.prototype.toString = function() {return `{Name: ${this.name}, DateOfBirth: ${this.dateOfBirth.getFullYear()+'-'+(this.dateOfBirth.getMonth()+1)+'-'+this.dateOfBirth.getDate()}}`;}

const peter = new Person('Peter', new Date(1985, 10, 10));
console.log(peter.toString());


//Question 4
$("#loginForm").submit(function(event) {
    event.preventDefault();
    const loginEmail = document.getElementById("loginEmail").value;
    const loginPwd = document.getElementById("loginPwd").value;
    const loginUrl = document.getElementById("loginUrl").value;
 
    console.log("Email: "+loginEmail+", Pwd: "+loginPwd+", Url: "+loginUrl);
 });

/*
Question 2 version 1

const employee = function () {
    this.salary = 0,
    this.hireDate = Date.now
    
    this.doJob = (jobTitle) => {
        console.log(`${this.name} is a ${jobTitle} who earns ${salaryFormatter.format(this.salary)}`); 
    }
 }
 
// add properties of person in employee function's prototype
employee.prototype = person;

let anna = new employee();*/

