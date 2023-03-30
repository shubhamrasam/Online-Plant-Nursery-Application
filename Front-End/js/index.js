let domain = "http://localhost:8088"; // local


document.querySelector(".form").addEventListener("submit", (event) => {
  event.preventDefault();
  var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "userName": "Ashish",
  "adminMobileNo": "9136523625",
  "adminPassword": "abcdefghi",
  "userEmail": "ashish@gmail.com"
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8088/admins", { mode: "no-cors" }, requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
});

// let userName = document.querySelector(".username");
// let userEmail =  document.querySelector(".useremail");
// let adminMobileNumber = document.querySelector(".mobile-number");
// let adminPassword = document.querySelector(".password");

// let obj = {};

// document.querySelector(".form").addEventListener("submit", (e) => {

//   e.preventDefault()
//   obj = {
   
//     userName:userName.value,
//     userEmail: userEmail.value,
//     adminMobileNumber : adminMobileNumber.value,
//     adminPassword : adminPassword.value
  
//   };
//   console.log(JSON.stringify(obj));
//   createAccount(obj);

// });

// async function createAccount(obj) {

//   try{
//        let res = await fetch("http://localhost:8088/admins", { mode: "no-cors" }, {
//       method:"POST",
//       headers: {
//           "Content-Type":"application/json"
//       },
//       body:JSON.stringify(obj)
//   })
//    if(res.CREATED){
//       let data=await res.json()
//       console.log(data)
//       alert("Registration Successful")
//      setTimeout(redirect,2000)
//    }
//    else{
//       alert("Server Down")
//    }
//   }
//   catch(err){
//      console.log(err)
//   } 
// }


// function submit(event) {
//   event.preventDefault();

//   let myHeaders = new Headers();
//   myHeaders.append("Content-Type", "application/json");

// let userName = document.querySelector(".username");
// let userEmail =  document.querySelector(".useremail");
// let adminMobileNumber = document.querySelector(".mobile-number");
// let adminPassword = document.querySelector(".password");

//   let raw = JSON.stringify({
//     adminMobileNumber: adminMobileNumber.value,
//     userName: userName.value,
//     adminPassword: adminPassword.value,
//     userEmail: userEmail.value,
//   });

//   let requestOptions = {
//     method: "GET",
//     headers: myHeaders,
//     body: raw,
//     redirect: "follow",
//   };

//   fetch(`${domain}/admins`, { mode: "no-cors" }, requestOptions)
//     .then((response) => response.text())
//     .then((result) => console.log(result))
//     .catch((error) => console.log("error", error));
// }



