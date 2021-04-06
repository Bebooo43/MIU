/*
First answer using pure JavaScript

const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", function(event){
    event.preventDefault(); 
    const loginEmail = document.getElementById("loginEmail").value;
    const loginPwd = document.getElementById("loginPwd").value;
    const loginUrl = document.getElementById("loginUrl").value;

    console.log("Email: "+loginEmail+", Pwd: "+loginPwd+", Url: "+loginUrl);
 });*/

 //using JQuery Lab9 question 4
$("#loginForm").submit(function(event) {
   event.preventDefault();
   const loginEmail = document.getElementById("loginEmail").value;
   const loginPwd = document.getElementById("loginPwd").value;
   const loginUrl = document.getElementById("loginUrl").value;

   console.log("Email: "+loginEmail+", Pwd: "+loginPwd+", Url: "+loginUrl);
});
