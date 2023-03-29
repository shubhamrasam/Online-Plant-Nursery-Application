let key = localStorage.getItem("uuid") || null;

document.querySelector("body").onload = () => {
  loginSucc();
};

function loginCheck() {
  if (key == null || key == undefined || key == "null") {
    if (window.confirm("Login first..")) {
      window.location.href = "login.html";
    }
  }
}

function walletService() {
  loginCheck();
}

function fundService() {
  loginCheck();
}

function accountService() {
  loginCheck();
}

function billService() {
  loginCheck();
}

function beneficiaryService() {
  loginCheck();
}

function transactionService() {
  loginCheck();
}

function loginSucc() {
  key = localStorage.getItem("uuid");

  if (key != null && key != "null" && key != undefined) {
    // Create a new Font Awesome icon element
    let icon = document.createElement("i");
    icon.classList.add("fas", "fa-sign-out-alt");
    // On click logout method will be called..
    icon.onclick = () => {
      logout();
    };

    // Append the anchor element to the div
    let div = document.querySelector(".navLinks");
    div.appendChild(icon);
  } else {
    let icon = document.querySelector(".fa-sign-out-alt");
    if (icon) {
      icon.remove();
    }
  }
}

function logout() {
  let key = localStorage.getItem('uuid');

  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };
  
  fetch(`http://localhost:8080/opn/logout?key=${key}`, requestOptions)
  .then((response) => response.text())
  .then((result) => console.log(result))
  .catch((error) => console.log("error", error));
  
  localStorage.setItem("uuid", null);

  loginSucc();
  // console.log("logout");
}
