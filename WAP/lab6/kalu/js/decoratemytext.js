/**
 * decoratemytext.js
 * 
 * @author O. Kalu
 * @since 2020-04-01
 */

 window.onload = function() {
   "use strict";

    const btnBiggerDecorations = this.document.querySelector("#btnBiggerDecorations");
    btnBiggerDecorations.addEventListener("click", setupBiggerDecorationsTimer);
    let biggerDecorationsEventTimer;

    function setupBiggerDecorationsTimer(event) {
        biggerDecorationsEventTimer = setInterval(doBiggerDecorations, 2000);
    }

    function doBiggerDecorations() {
        const textAreaText = document.querySelector("#textAreaText");
        const strCurrFontSize = textAreaText.style.fontSize; // 8pt
        // "8" = 82
        const numCurrentFontSize = strCurrFontSize.substring(0,strCurrFontSize.length - 2);
        let intNewFontSize = parseInt(numCurrentFontSize) + 2;
        textAreaText.style.fontSize =  intNewFontSize + "pt";
        console.log("current fontsize: " + textAreaText.style.fontSize);
    }

    const chkBling = this.document.querySelector("#chkBling");
    chkBling.addEventListener("change", doBling);
    function doBling(event) {
        const textAreaText = document.querySelector("#textAreaText");
        if(event.target.checked) {
            textAreaText.style.fontWeight = "bold";
            textAreaText.style.color = "green";
            textAreaText.style.textDecoration = "underline";
        } else {
            textAreaText.style.fontWeight = "normal";
            textAreaText.style.color = "black";
            textAreaText.style.textDecoration = "none";
        }
    }

    const btnCancelBiggerDecorations = document.querySelector("#btnCancelBiggerDecorations");
    btnCancelBiggerDecorations.addEventListener("click", cancelBiggerDecorationsTimer);

    function cancelBiggerDecorationsTimer(event) {
        clearInterval(biggerDecorationsEventTimer);
    }

    const textAreaText = document.querySelector("#textAreaText");
    const btnResetText = this.document.querySelector("#btnResetText");
    btnResetText.addEventListener("click",
        event => {
            textAreaText.value = "Sample Item 1" + "\n" + "\n" + " " + "Sample Item 2";
            textAreaText.style.fontSize = "8pt";
        }
    );

    // Converting to pig latin
    const btnConvertTextToPigLatin = this.document.querySelector("#btnConvertTextToPigLatin");
    btnConvertTextToPigLatin.addEventListener("click", 
        event => {
            let newText = ""; 
            const currentText = document.querySelector("#textAreaText").value;
            const wordsArray = currentText.split(" ");
            //this.console.log(wordsArray.length);
            for (const word of wordsArray) {
                // word = "hello";
                const firstChar = word.charAt(0);
                // check alphabetic char only i.e if firstChar is A-Z or a-z
                if((firstChar.charCodeAt(0) >= 65 && firstChar.charCodeAt(0) <= 90) || (firstChar.charCodeAt(0) >= 97 && firstChar.charCodeAt(0) <= 122)) {
                    const firstCharLower = firstChar.toLowerCase();
                    if("aeiou".indexOf(firstCharLower) != -1) {
                        // vowel found
                        newText = newText.concat(word, "ay", " ");
                    } else {
                        // get consonant or consonant cluster
                        let conso = firstChar.toLowerCase();
                        let i = 1;
                        let nextChar = word.charAt(i);
                        while("aeiou".indexOf(nextChar) == -1) {
                            conso += nextChar.toLowerCase();
                            i++;
                            nextChar = word.charAt(i);
                        }
                        newText = newText.concat(word.charAt(i).toUpperCase(), word.substring(i+1), conso, "ay", " ");
                    }
                } else if(firstChar == " " || firstChar.charCodeAt(0) == 13) {
                    newText = newText.concat(word);
                } else {
                    newText = newText.concat(word, " ");
                }
            }
            document.querySelector("#textAreaText").value = newText;
        }
    );
    
 };