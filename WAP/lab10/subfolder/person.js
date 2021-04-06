export class Person {
    
    constructor(name, dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //GETs and SETs
    get name(){return this._name;}
    get dateOfBirth(){return this._dateOfBirth;}

    set name(newName){this._name = newName;}
    set dateOfBirth(newDateOfBirth){this._dateOfBirth = newDateOfBirth;}
}

Person.prototype.toString = function() {return `{ Name: ${this.name}, Date Of Birth: ${this.dateOfBirth.getFullYear()+'-'+(this.dateOfBirth.getMonth()+1)+'-'+this.dateOfBirth.getDate()}}`;};