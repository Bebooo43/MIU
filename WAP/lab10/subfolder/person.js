"use strict";

export class Person {

    //private fields declarations (Encapsulation)
    #name = '';
    #dateOfBirth = null;
    constructor(name, dateOfBirth){
        this.#name = name;
        this.#dateOfBirth = dateOfBirth;
    }

    //GETs and SETs
    get name(){return this.#name;}
    get dateOfBirth(){return this.#dateOfBirth;}

    set name(newName){this.#name = newName;}
    set dateOfBirth(newDateOfBirth){this.#dateOfBirth = newDateOfBirth;}

    toString(){
        return `{ Name: ${this.name}, Date Of Birth: ${this.dateOfBirth.getFullYear()+'-'+(this.dateOfBirth.getMonth()+1)+'-'+this.dateOfBirth.getDate()}}`;
    };
}

