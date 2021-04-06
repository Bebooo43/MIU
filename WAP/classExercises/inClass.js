//Replace in place
let array = [1,2,3,4,5,6,7,8,9,10];

//console.log(array.split("").reverse().join(""));
function reverse (array) {
    var i = 0,
        n = array.length,
        middle = Math.floor(n / 2),
        temp = null;
  
    for (; i < middle; i += 1) {
       temp = array[i];
       array[i] = array[n - 1 - i];
       array[n - 1 - i] = temp;
    }
    return array;
  }

console.log(reverse(array));

/*
  Define closure: are functions that binds to free variables
  Free variables: variable refered to by a function that is not one of its parameters or local variables
  
  A closure is defined when a (n inner) function is defined that has free variables

  Inner function closes over free variables when it is returned
    - Saves references to the names, not values
    
  Example 1 below:
*/
const x = 1;
function f() {
  let y = 2;
  const sum = function() {
    const z = 3;
    console.log(x + y + z);
  }
  y = 10;
  return sum;
} //end of f
const g = f();
g();

/**
 * Common bug: example of var inside for loop
 *  fixing with: helperMethod or let in ES6
 * 
 * 3 practical uses: encapsulation, namespace protection(module pattern) and function factory e.g. makeSizer(?);
 * 
 */
//------------------------

/*

display : flex

display Specifies the type of box used for an HTML element
flexdirection Specifies the direction of the flexible items inside a flex container
justifycontent Horizontally aligns the flex items when the items do not use all available space on the 
main-axis
align-items Vertically aligns the flex items when the items do not use all available space on the crossaxis
flex-wrap Specifies whether the flex items should wrap or not, if there is not enough room for them 
on one flex line
aligncontent Modifies the behavior of the flex-wrap property. It is similar to align-items, but instead of 
aligning flex items, it aligns flex lines
flex-flow A shorthand property for flex-direction and flex-wrap

display:grid

number and width of columns
display: grid;
grid-template-columns: 80px 200px auto 40px;

height of rows
grid-template-rows: 80px 200px;
*/


/*
  Simple crud JS
  from: https://www.javaguides.net/2020/11/javascript-crud-example-tutorial.html

var selectedRow = null

function onFormSubmit() {
    if (validate()) {
        var formData = readFormData();
        if (selectedRow == null)
            insertNewRecord(formData);
        else
            updateRecord(formData);
        resetForm();
    }
}

function validate() {
    isValid = true;
    if (document.getElementById("fullName").value == "") {
        isValid = false;
        document.getElementById("fullNameValidationError").classList.remove("hide");
    } else {
        isValid = true;
        if (!document.getElementById("fullNameValidationError").classList.contains("hide"))
            document.getElementById("fullNameValidationError").classList.add("hide");
    }
    return isValid;
}

// insert in the index first, remove n elements and offset teh remaiing to the right
fruits.splice(2, 0, "Lemon", "Kiwi");

slice work as substring (index, end) - but this end not count
*/

/*
   Practice exercise
   Define a constructor function named Student with properties: studentId, name



*/