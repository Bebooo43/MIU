import {Person} from "./person.js"
import {Employee} from "./employee.js"


let p1 = new Person('Ana Smith', new Date(1998,11,15));
let p2 = new Person('Bob Jone', new Date(1945,10,16));
let p3 = new Person('Carlos Slim Helu', new Date(1976, 8,24));
let array = [p1,p2,p3];

console.log('Question 1 \n');
array.forEach(element => {
    console.log(element.toString());
});


console.log('Question 2 \n');
let e1 = new Employee('Jim Hanson', null, 245990, null);
e1.doJob('Software Engineer');
//console output should be: Jim Hanson is a Software Engineer who earns $245,990.00
                            