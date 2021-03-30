const loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click", function(){ 
    const loginEmail = document.getElementById("loginEmail").value;
    const loginPwd = document.getElementById("loginPwd").value;
    const loginUrl = document.getElementById("loginUrl").value;

    console.log("Email: "+loginEmail+", Pwd: "+loginPwd+", Url: "+loginUrl);
 });
