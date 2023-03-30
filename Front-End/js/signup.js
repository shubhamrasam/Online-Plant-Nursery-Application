// let domain = "http://localhost:8088"; // local

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

  fetch(`http://localhost:8088/admins`, { mode: "no-cors" }, requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.log("error", error));
}

