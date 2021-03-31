
//Question 1
function max(n1,n2){
    if(n1 > n2) return n1;
    else return n2;
}
console.log(max(1,2));

//Question 2
function maxOfThree(n1,n2, n3){
    if(n1 > n2 && n1 > n3) return n1;
    else if(n2 > n1 && n2 > n3) return n2;
    else return n3;
} 
console.log(maxOfThree(1,2,3));

//Question 3
function isVowelOption1(x){
    var listOfVowels = "aAeEiIoOuU";
    return x.length ==1 && listOfVowels.indexOf(x) > -1;
}
console.log(isVowelOption1('a'));

//Testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee TODO
function isVowelOption2(x){
    var lowerX = x.toLowerCase();
    var result = false;
    switch (lowerX) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            result = true;
            break;
    }
    return result;
}
console.log(isVowelOption2('a'));

//Question 4
function sum(array) {
    var result = 0;
    for (let index = 0; index < array.length; index++) {
        result += array[index];
    }
    return result;
}
console.log(sum([1,2,3]));

function multiply(array) {
    var result = null;
    if(array.length >= 1){
        result = array[0];
        for (let index = 1; index < array.length; index++) {
            result *= array[index];
        }
    }
    return result;
}
console.log(multiply([1,2,3]));

//Question 5
function reverseV1(string) {
    var result = '';
    for (let index = string.length -1; index >= 0; index--) {
        result += string[index];
    }
    return result;
}
console.log(reverseV1('abcde'));

function reverseV2(string) {
    var result = [];
    for (let index = string.length -1; index >= 0; index--) {
        result.push(string[index]);
    }
    return result.join("");
}
console.log(reverseV2('abcde'));

//Question 6
function findLongestWord(array) {
    var longest = 0;
    for (let index = 0; index < array.length; index++) {
       if(longest < array[index].length) longest = array[index].length;
    }
    return longest;
}
console.log(findLongestWord(['a','ab','abc','abcd','abcde']));

//Question 7
function filterLongWords(array, wordSize) {
    var newArray = [];
    for (let index = 0; index < array.length; index++) {
        if(array[index].length > wordSize) newArray[newArray.length++] = array[index];
    }
    return newArray;
}
console.log(filterLongWords(['a','ab','abc','abcd','abcde'], 3));

function filterLongWordsFunc(array, wordSize) {
    return array.filter(word => word.length > wordSize);
}
console.log(filterLongWordsFunc(['a','ab','abc','abcd','abcde'], 3));


//Question 8
function computeSumOfSquares(array) {
    var result = array.reduce((x, y) => x + Math.pow(y, 2));
    return result;
}
console.log(computeSumOfSquares([1,2,3,4]));

//Question 9
function printOddNumbersOnly(array) {
    console.log(array.filter(function (element, index, array) {
      return element % 2 !== 0;  
    }));
}
console.log(printOddNumbersOnly([1,2,3,4]));

//Question 10
function computeSumOfSquaresOfEvensOnly(array) {
    return array.filter(element=>element % 2 === 0).map(e=>e*e).reduce((x,y) => x + y);
}
console.log(computeSumOfSquaresOfEvensOnly([1,2,3,4]));

//Question 11
function sumFunctionalWay(array) {
    var result = array.reduce((x,y) => x + y);
    return result;
}
console.log(sumFunctionalWay([1,2,3,4]));

function multiplyFunctionalWay(array) {
    if(array.length < 1)
        throw new Error('Invalid Input');
    var result = array.reduce((x,y) => x * y, 1);//this one if to specify that the first element should be one to avoid 0 if is the first element of the array
    return result;
}
console.log(multiplyFunctionalWay([1,2,3,4]));

//Question 12
function findSecondBiggest(array) {
    if(array.length < 2)
        throw new Error('Invalid size. Must have at least two elements');

    let biggest = (array[0] > array[0]) ? array[0] : array[1];
    let secondBiggest = (biggest === array[0]) ? array[1] : array[0];

    for (let index = 2; index < array.length; index++) {
        if(array[index] > biggest){
            secondBiggest = biggest;
            biggest = array[index];
        }else if(array[index] > secondBiggest){
            secondBiggest = array[index];
        }
    }
    return secondBiggest;
}
console.log(findSecondBiggest([1,2,3,4]));

//Question 13
function printFibo(n,a,b){
    if(n === 0) return;
    if(n === 1) return a;
    else if( n === 2) return `${a}, ${b}`;
    else {
        let counter = 0; let out = [a,b];
        while(counter < n-2){
            out.push(out[counter]+out[counter+1]);
            counter++;
        }
        return out;
    }
}
console.log(printFibo(5,0,1));

//Try 13 using recursion
//Try 13 using Functional Programming

//Question 14 (see webform pages)

//Question 15
function getCurrentDate(){
    const currentDate = new Date().toLocaleString();
    const h1Time = document.getElementById("h1Time");
    h1Time.innerText = currentDate;
}
setInterval(getCurrentDate,1000);