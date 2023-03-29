let domain = "http://localhost:8088"; // local

document.querySelector("form").addEventListener("submit", () => {
  submit(event);
});

function submit(event) {
  event.preventDefault();

  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  let adminMobileNumber = document.getElementById("mobile").value;
  let userName = document.getElementById("name").value;
  let adminPassword = document.getElementById("password").value;
  let userEmail = document.getElementById("email").value;

  let raw = JSON.stringify({
    adminMobileNumber: adminMobileNumber,
    userName: userName,
    adminPassword: adminPassword,
    userEmail: userEmail,
  });

  let requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(`${domain}/admins`, requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.log("error", error));
}

// loginUserButton.addEventListener("click", async function () {
//   try {
//     let res = await fetch(userLoginURL, {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify({
//         username: loginUserUsername.value,
//         password: loginUserPassword.value,
//       })
//     });
//     let data = await res.json();
//     console.log(data)
//     localStorage.setItem("localAccessToken", data.accessToken);
//     localStorage.setItem("userId", data.user.id);
//     notificationWrapper.innerHTML = `
//       <h5 class="notification info">
//       hey ${loginUserUsername.value}, welcome back!
//       </h5>
//       `;
//       getTodoButton.addEventListener("click", async function(){

//         let res = await fetch(urlAllTodosOfUser ,{
//             method:"GET",
//             headers:{
//              "Content-Type": "application/json",
//              Authorization : `Bearer ${userAuthToken}`
//             }
//         })
//         let data = await res.json()
//         console.log(data)
//         renderData(data)
//      })

//   } catch (error) {
//     console.log(error);
//   }
// });
