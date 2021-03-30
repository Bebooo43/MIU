
function max(n1,n2){
    if(n1 > n2) console.log(n1);
    else console.log(n2);
}

function maxOfThree(n1,n2, n3){
    if(n1 > n2 && n1 > n3) console.log(n1);
    else if(n2 > n1 && n2 > n3)console.log(n2);
    else console.log(n3);
} 

function isVowel(x){
    var listOfVowels = "aAeEiIoOuU";
    console.log(x.length ==1 && listOfVowels.indexOf(x) > -1);
}

function sum(array) {
    var result = 0;
    for (let index = 0; index < array.length; index++) {
        result += array[index];
    }
    console.log(result);
}

function multiply(array) {
    var result = null;
    if(array.length >= 1){
        result = array[0];
        for (let index = 1; index < array.length; index++) {
            result *= array[index];
        }
    }
    console.log(result);
}

function reverse(string) {
    var result = '';
    for (let index = string.length -1; index >= 0; index--) {
        result += string[index];
    }
    console.log(result);
}

function findLongestWord(array) {
    var longest = 0;
    for (let index = 0; index < array.length; index++) {
       if(longest < array[index].length) longest = array[index].length;
    }
    console.log(longest);
}

function filterLongWords(array, wordSize) {
    var newArray = [];
    for (let index = 0; index < array.length; index++) {
        if(array[index].length >= wordSize) newArray[newArray.length++] = array[index];
    }
    console.log(newArray);
}

function computeSumOfSquares(array) {
    var result = array.reduce((x, y) => x + Math.pow(y, 2));
    console.log(result);
}

function printOddNumbersOnly(array) {
    console.log(array.filter(function (element, index, array) {
      return element % 2 !== 0;  
    }));
}

function computeSumOfSquaresOfEvensOnly(array) {
    console.log(
        array.filter(element=>element % 2 === 0).map(e=>e*e).reduce((x,y) => x + y)       
    );
}

function sumFunctionalWay(array) {
    var result = array.reduce((x,y) => x + y);
    console.log(result);
}

function multiplyFunctionalWay(array) {
    var result = array.reduce((x,y) => x * y);
    console.log(result);
}

function findSecondBiggest(array) {
    var biggest, secondBiggest;
    if(array.length < 2){
        console.log('invalid size!!!');
        return;
    }

    biggest = array[0];
    secondBiggest = array[1];

    if(biggest < secondBiggest) {
        biggest = secondBiggest;
        secondBiggest = biggest;
    }

    for (let index = 2; index < array.length; index++) {
        if(array[index] > biggest){
            secondBiggest = biggest;
            biggest = array[index];
        }else if(array[index] > secondBiggest){
            secondBiggest = array[index];
        }
    }

    console.log(secondBiggest);
}

//Question 13
function printFibo(n,a,b){
    let counter =0; let out = [a,b];
    while(counter < n-2){
        out.push(out[counter]+out[counter+1]);
        counter++;
    }
    
    console.log(out);
}

function getCurrentDate(){
    const currentDate = new Date().toLocaleString();
    const h1Time = document.getElementById("h1Time");
    h1Time.innerText = currentDate;
}

function startclock(){
    setInterval(getCurrentDate,1000);
}
startclock();
