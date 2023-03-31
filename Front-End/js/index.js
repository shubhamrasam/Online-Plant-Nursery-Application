let domain = "http://localhost:8088"; // local


let userName = document.querySelector(".username");
let userEmail =  document.querySelector(".useremail");
let adminMobileNumber = document.querySelector(".mobile-number");
let adminPassword = document.querySelector(".password");

let obj = {};

document.querySelector(".form").addEventListener("submit", (e) => {

  e.preventDefault()
  obj = {
   
    userName:userName.value,
    userEmail: userEmail.value,
    adminMobileNumber : adminMobileNumber.value,
    adminPassword : adminPassword.value
  
  };
  console.log(JSON.stringify(obj));
  createAccount(obj);

});

async function createAccount(obj) {

  try{
       let res = await fetch("http://localhost:8088/admins", {
      method:"POST",
      headers: {
          "Content-Type":"application/json"
      },
      body:JSON.stringify(obj)
  })
   if(res.created){
      let data=await res.json()
      console.log(data)
      alert("Registration Successful")
     setTimeout(redirect,2000)
   }
   else{
      alert("Server Down")
   }
  }
  catch(err){
     console.log(err)
  } 
}




