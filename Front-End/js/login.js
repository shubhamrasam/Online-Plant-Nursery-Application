let domain = "http://localhost:8088";

document.querySelector("form").addEventListener("submit", () => {
  login(event);
});

function login(e) {
  e.preventDefault();

  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  let adminMobileNumber = document.getElementById("mobile").value;
  let adminPassword = document.getElementById("password").value;

  let raw = JSON.stringify({
    adminMobileNumber: adminMobileNumber,
    adminPassword: adminPassword,
  });

  let requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(`${domain}/admin/login`, { mode: "no-cors" }, requestOptions)
    .then((response) => {
      if (response.status == 200) {
        response.text().then((res) => {
          localStorage.setItem("uuid", res);

          window.location.href = "index.html";
        });
      } else {
        if (
          window.confirm(
            "Unnable to Login " +
              "/n" +
              "Press OK to Register to OPN application"
          )
        ) {
          window.location.href = "signup.html";
        }
      }
    })
    .catch((error) => {
      // if (window.confirm("Unnable to Login " +"/n"+"Press OK to Register to OPN application"+"/n"+`Error:${error}`)) {
      //   window.location.href = "signup.html";
      // }
      // console.log(error);
    });
}
