
let userName = document.querySelector(".uname");
let userEmail = document.querySelector(".email-address");
let customerMobileNumber = document.querySelector(".mobile-number");
let customerPassword = document.querySelector(".password");
let houseNumber = document.querySelector(".houseNumber");
let colony = document.querySelector(".colony");
let city = document.querySelector(".city");
let state = document.querySelector(".state");
let pincode = document.querySelector(".pincode");


let obj = {};
let address = {};

document.querySelector(".create-form").addEventListener("submit", (e) => {

  e.preventDefault()

  

  obj = {
    userName : userName.value,
    userEmail: userEmail.value,
    customerMobileNumber : customerMobileNumber.value,
    customerPassword : customerPassword.value,
    address : {
        houseNumber : houseNumber.value,
        colony : colony.value,
        city : city.value,
        state : state.value,
        pincode : pincode.value
      }
  };
  console.log(JSON.stringify(obj));
  createAccount(obj);

});

async function createAccount(obj) {

  try{
       let res = await fetch("http://localhost:8088/customers", {
      method:"POST",
      headers: {
          "Content-Type":"application/json"
      },
      body:JSON.stringify(obj)
  })
//    if(res.created){
      let data=await res.json();
      console.log(data);
      alert("Registration Successful");
    //   setTimeout(redirect,2000)
//    }
//    else{
    //   alert("Server Down")
//    }
  }
  catch(err){
     console.log(err)
  } 
}
