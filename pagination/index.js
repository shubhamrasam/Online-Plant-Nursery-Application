let baseURL = "http://localhost:8088//plants/getallbypage?pageNo=";

let pageNo = document.querySelector(".active").innerText - 1;

let allPages = document.querySelectorAll(".page");

for (let page of allPages) {
  if (page.classList.contains("active")) {
    page.classList.remove("active");
  }

  page.addEventListener("click", function (e) {
    page.classList.add("active");
  });
}

// import { footer } from "../components/footer.js";
import { brands_function } from "./refine.js";
// ------------------> html elements
let popHandler = document.querySelector(".pop-handler");
// let footerHTLM = document.querySelector("#footer");
let brands = document.querySelector(".brands");
let page1 = document.querySelector(".page-btn-1");
let page2 = document.querySelector(".page-btn-2");
let page3 = document.querySelector(".page-btn-3");
let page4 = document.querySelector(".page-btn-4");
let page5 = document.querySelector(".page-btn-5");

// ------------------> export functions
brands.innerHTML = brands_function();
// footerHTLM.innerHTML = footer();

// let selectData = document.querySelector("#select");
// selectData.addEventListener("change",function(){
//     if(selectData.value == "Select"){
//         displayData(normalData)
//     }else{
//         if(selectData.value == "Low to High"){
//              wholeData.sort((a,b)=>{
//              return a.price - b.price;
//              })
//         }
//          if(selectData.value == "High to Low"){
//              wholeData.sort((a,b)=>{
//              return b.price - a.price
//              })
//         }
//         displayData(wholeData);
//     }
// })

// ------------------> fetch all data functions
async function fetchData(page = 1) {
  loading();
  try {
    let response = await fetch(`${baseURL}` + pageNo, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    // if (response.ok) {
    let product_data = await response.json();
    popHandler.innerHTML = null;
    // console.log(product_data);
    renderData(product_data);
    // } else {
    //   console.dir(response);
    // }
  } catch (error) {
    console.log(error);
  }
}
// ------------------> onloade
window.addEventListener("load", () => {
  fetchData();
});

// --------------------------------------------------------------------------------------------->rendering part

// async function fetchData(page = 1) {
//   loading();
//   try {
//     let response = await fetch(`${baseURL}/products?p=${page}&l=${18}`, {
//       method: "GET",
//       headers: {
//         "Content-Type": "application/json",
//       },
//     });
//     if (response.ok) {
//       let product_data = await response.json();
//       popHandler.innerHTML = null
//       // console.log(product_data);
//       renderData(product_data);
//     } else {
//       console.dir(response);
//     }
//   } catch (error) {
//     console.log(error);
//   }
// }

// ------------------>willl make arr of cards
function getCard(data) {
  let formatedData = data.map((ele) => {
    return `
                <div class="product-cards" id ="${ele.plantId}" >
                <div class=" product-cards-fav">
                    <div>
                    <lord-icon
                    class="fav-btn"
                    src="https://cdn.lordicon.com/pnhskdva.json"
                    trigger="hover"
                    style="width:40px;height:40px">
                    </lord-icon>
                    </div>
                </div>
                <div class="product-image-div">
                    <img src=${ele.url}
                        alt="${ele.plantCommonName}">
                </div>
                <div class=" product-title">
                    <p>${ele.plantCommonName}</p>
                </div>
                <div class="product-discount-div">
                    <button class="product-discount-button">25% off with code RREPLAY</button>
                </div>
                <div class="product-price">
                    <span class="product-price">$${ele.plantCost}</span>
                </div>
                <div class="product-button">
                
                    <a href="payment.html"><button  class="productQuickbuy">SHOP NOW</button></a>
                </div>
                <div class="product-reviews">
                        <p>⭐⭐⭐⭐&#160(234)</p>
                </div>
            </div>


        `;
  });
  return formatedData.join("");
}
// ------------------>
function renderData(data) {
  let product_container = document.querySelector(".product-container-reder");
  product_container.innerHTML = getCard(data);

  // ------------------>fetching all fav button after data displayed on DOM

  let all_fav_btns = document.querySelectorAll(".fav-btn");
  for (let btn of all_fav_btns) {
    btn.addEventListener("click", (event) => {
      let product_id = event.path[3].plantId;
      loading();
      add_to_fav(product_id);
    });
  }
  // ------------------>filtering data
  // all input tag
  let all_input = document.querySelectorAll("input");
  for (let btn of all_input) {
    btn.addEventListener("click", (event) => {
      console.log(event.path[1].innerText);
      let sort_url =
        "hhttp://localhost:8088/plants/getall?key=TQqqoA?sortBy=price&order=aesc&p=1&l=24";
      fetchSortedData(sort_url);
    });
  }
  // ------------------>productQuickbuy
  let all_quick_btn = document.querySelectorAll(".productQuickbuy");
  for (let btn of all_quick_btn) {
    btn.addEventListener("click", (event) => {
      loading();
      let product_id = event.path[2].plantId;
      let product = getProduct(product_id);
      product.then((data) => {
        makePopUp(data.url, data.plantCommonName, data.plantCost);
        add_to_cart(product_id);
        localStorage.setItem("quick-data", JSON.stringify(data));
      });
    });
  }
  // all img tag
  let allImg = document.querySelectorAll(".product-image-div");
  console.log(allImg);
  for (let btn of allImg) {
    btn.addEventListener("click", (event) => {
      let product_id = event.path[2].plantId;
      let product = getProduct(product_id);
      loading();
      product.then((data) => {
        localStorage.setItem("quick-data", JSON.stringify(data));
        window.location.href = "./index.html";
      });
    });
  }
}

// ------------------> make pop-up fun
function loading() {
  popHandler.innerHTML = `
  <div style="width: 100%;position: fixed;top: 1%;height: 100vh;backdrop-filter: blur(5px)" class="notification-popup" id="quickbuy-popup">
  <lord-icon class="notification-loding" src="https://cdn.lordicon.com/kvsszuvz.json" trigger="loop"
      colors="primary:#121331,secondary:#08a88a" style="width:450px;height:450px">
  </lord-icon>
  </div>
`;
}

// ------------------> make pop-up fun
function makePopUp(url, plantCommonName, plantCost) {
  popHandler.innerHTML = `
  <div class="quickbuy-popup" id="quickbuy-popup">
  <div class="quickbuy-popup-header">
      <h3>Added to Your Cart</h3>
      <svg class="x-logo" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512">
          <path
              d="M310.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L160 210.7 54.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L114.7 256 9.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 301.3 265.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L205.3 256 310.6 150.6z" />
      </svg>
  </div>
  <hr>
  <div class="quickbuy-popup-body popup-scroll">
      <div class="whathehell" >
          <div class=" quckbuy-img">
              <img src="${url}" alt="${plantCommonName}">
          </div>
          <div class="quckbuy-des">
              <h5>${plantCommonName}</h5>
              <p>Quantity 1</p>
              <h4>$${plantCost}</h4>
          </div>
      </div>

      <hr>
      <div class="cart-deatils ">
          <div>
              <h5>Subtotal:12</h5>
                 <h6> (12 items in your cart)</h6>
          </div>
          <div>
              TOTAL : $1198
          </div>
      </div>
      <hr>
      <div class=" quckbuy-btn padding-class">
          <div class="quckbuy-shoping-btn padding-class">
              <button type="button" class="btn btn-outline-info con-shopping btn-lg btn-block">CONTINUE SHOPPING</button>
          </div>
          <div class="quckbuy-cart-btn padding-class">
              <button type="button" class="btn pop-productQuickbuy  view-cart btn-lg btn-block">VIEW CART</button>
          </div>
      </div>
      <hr>
      <div class="pop-image">
          <img src="../images/quick-pop-up-img.png" alt="">
      </div>
  </div>
</div>`;

  // ------------------>redicrecting cart and con-shopping-btn
  document
    .querySelector(".con-shopping")
    .addEventListener("click", () => (popHandler.innerHTML = null));
  document
    .querySelector(".view-cart")
    .addEventListener("click", () => (window.location.href = "./index.html"));

  // ------------------>closing and overlay button
  document
    .querySelector(".x-logo")
    .addEventListener("click", () => (popHandler.innerHTML = null));
}

// ------------------>add to wishlist
let add_to_fav = async (product_id) => {
  try {
    let product = await getProduct(product_id);
    let productName = product.title;
    productName = productName.substring(0, 20);
    let add_to_fav_res = await fetch(`${baseURL}/wishlist`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    });
    // ---------------------------------success---->
    popHandler.innerHTML = `
  <div style="background-color:rgba(255, 255, 255, 0);backdrop-filter: blur(5px)" class="quickbuy-popup" id="quickbuy-popup">
    <div class="quickbuy-popup-header">
      <h3>Added to WishList ❤</h3>
      <svg class="x-logo" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512">
          <path
              d="M310.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L160 210.7 54.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L114.7 256 9.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 301.3 265.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L205.3 256 310.6 150.6z" />
      </svg>
    </div>
  <hr>
  <div class="quickbuy-popup-body popup-scroll">
      
  <lord-icon class="wishlistloading"
  src="https://cdn.lordicon.com/tqywkdcz.json"
  trigger="hover"
  style="width:450px;height:450px">
</lord-icon>
   </div>
  </div>`;
    // ---------------------------------clsoing---->
    document
      .querySelector(".x-logo")
      .addEventListener("click", () => (popHandler.innerHTML = null));
  } catch (error) {
    alert(error);
  }
};
// -----------------------> add to cart
let add_to_cart = async (product_id) => {
  try {
    let product = await getProduct(product_id);

    let add_to_cart_res = await fetch(`${baseURL}/cart`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    });
  } catch (error) {
    alert("Trouble in adding product to cart");
  }
};

// get one product
let getProduct = async (plantId) => {
  try {
    let product_res = await fetch(`${baseURL}${plantId}`, {
      method: "GET",
      headers: {
        "Content-Type": "applicaton/json",
      },
    });
    if (product_res.ok) {
      let product = await product_res.json();
      return product;
    } else {
      alert("alert in getting the data");
    }
  } catch (error) {
    console.log(error);
  }
};

// --------------------------> sorting feature
let sorting_btn = document.querySelector("#sort-by");
sorting_btn.addEventListener("change", () => {
  console.log(sorting_btn.value);
  if (sorting_btn.value === "default") fetchData();

  if (sorting_btn.value === "price-ases") {
    let sort_url =
      "http://localhost:8088/plants/getall?key=TQqqoA?sortBy=price&order=aesc&p=1&l=24";
    fetchSortedData(sort_url);
  }
  if (sorting_btn.value === "price-dses") {
    let sort_url =
      "http://localhost:8088/plants/getall?key=TQqqoA?sortBy=price&order=desc&p=1&l=24";
    fetchSortedData(sort_url);
  }
  if (sorting_btn.value === "atoz") {
    let sort_url =
      "http://localhost:8088/plants/getall?key=TQqqoA?sortBy=title&order=aesc&p=1&l=24";
    fetchSortedData(sort_url);
  }
  if (sorting_btn.value === "ztoa") {
    let sort_url =
      "http://localhost:8088/plants/getall?key=TQqqoA?sortBy=title&order=desc&p=1&l=24";
    fetchSortedData(sort_url);
  }
});
async function fetchSortedData(sort_url) {
  try {
    let response = await fetch(`${sort_url}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    if (response.ok) {
      let product_data = await response.json();
      console.log(product_data);
      renderData(product_data);
    } else {
      console.dir(response);
    }
  } catch (error) {
    console.log(error);
  }
}

// --------------------------> sorting feature
page1.addEventListener("click", () => {
  fetchData(1);
});
page2.addEventListener("click", () => {
  fetchData(2);
});
page3.addEventListener("click", () => {
  fetchData(3);
});
page4.addEventListener("click", () => {
  fetchData(4);
});
page5.addEventListener("click", () => {
  fetchData(5);
});

// notitication
export { loading };
export { makePopUp };

// =================================================================
