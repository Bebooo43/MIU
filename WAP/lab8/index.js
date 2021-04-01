//Question 6
const count = { 
    counter: 0, 
    add: function() { 
    this.counter += 1; 
    }, 
    reset: function() { 
    this.counter = 0; 
    } 
}

//Question 7 - teorical

//Question 8
function make_adder(param) { 
    let counter = 0; 
    return function() { 
    return counter += param; 
    } 
}; 
//Question 9 - teorical

//Question 10
const employee = (function() { 
    let name = '', age = 0, salary = 0.0; 
    function getName() {return name;} 
    function getAge() {return age;} 
    function getSalary() {return salary;} 
    
    const setName = function(newName) {name = newName;} 
    const setAge = function(newAge) {age = newAge;} 
    const setSalary = function(newSalary) {salary = newSalary;} 
    return { 
    setName: setName, 
    setAge: setAge, 
    setSalary: setSalary, 
    increaseSalary: function increaseSalary(percentage){ 
    setSalary(getSalary() + (getSalary()*percentage));//Alternative way :
    1 + percentage/100
    }, 
    incrementAge: function incrementAge(){return age = (getAge() + 1);}, 
    } 
   })(); 

//Question 11
employee.address = ''; 
employee.getAddress = function () { return employee.address; }; 
employee.setAddress = function (newAddress) { employee.address = newAddress; }; 