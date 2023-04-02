console.log("Welome in cart.js");

let AddressData = JSON.parse(localStorage.getItem("AddressData"));
let showAddress = document.querySelector(".show-address");
if (AddressData) {
	showAddress.innerHTML = `🏠${AddressData.name},${AddressData.address},${AddressData.pincode}`;
}
let existingUserDataFromLS = JSON.parse(localStorage.getItem("existingUser"));

const getCartDataFromDatabase = async () => {
	const url = `http://localhost:8088/plants/getall?key=TQqqoA`;
	const res = await fetch(url);
	const data = await res.json();
	console.log("data: ", data);
	filterDataForUser(data);
};
getCartDataFromDatabase();

// todo filtering the data
const filterDataForUser = (data) => {
	const temp = data.filter((el) => {
		return el["email"] == existingUserDataFromLS.email;
	});
	console.log("temp: ", temp);
	if (temp.length) {
		getTotalPrice(temp);
		appendFilterData(temp);
	} else {
		console.log("empty");
		appendEmpty();
	}
};

// todo empty
const appendEmpty = () => {
	document.querySelector("#lhs_cartDiv").innerHTML = `<div id="EmptyBag">
												<div id="EmptyCart">
													<img src="./images/cart.jpeg" alt="">
												</div>
												<div id="shop_more">
													<a href="index.html"><button>SHOP NOW</button></a>
												</div>
											</div>`;
};

const appendFilterData = (data) => {
	document.querySelector("#lhs_cartDiv").innerHTML = "";
	data.forEach((el, i) => {
		const showTemplate = `<div class="fav-item">
                                   <div class="fav-image">
                                        <img title="${el.plantId}" src="${el.url}"
                                             alt="">
                                   </div>
                                   <div class="detail">
                                        <div class="product-name">
                                             <p>Sephora</p>
                                        </div>
                                        <div class="product-desc">
                                             <p>${el.index}</p>
                                        </div>
                                        <div class="product-colour">
                                             <p>Color : Crimson</p>
                                        </div>
                                        <div class="product-more-offer">
                                             <p>5 more offer</p>
                                        </div>
                                        <div class="move-remove">
                                             <div><button onclick="MoveToFavorite('${el.plantId}')">Move to Favorites</button></div>
                                             <div><button onclick="RemoveFromCart('${el.plantId}')">Remove</button></div>
                                        </div>
                                   </div>

                                   <div class="fav-item-last">
                                        <div>
                                             <span>Qty: </span>
                                             <select name="quantity" onchange="SelectItemQty('${el.plantCost}','${i}')" class="qty-${i}" id="Cart-product-qantity">
                                                  <option value="1">1</option>
                                                  <option value="2">2</option>
                                                  <option value="3">3</option>
                                                  <option value="4">4</option>
                                             </select>
                                        </div>
                                        <div class="product-price" id="p-${i}">
                                             <p>${el.plantCost}</p>
                                        </div>
                                   </div>
                              </div>`;
		document.querySelector("#lhs_cartDiv").innerHTML += showTemplate;
	});
};

// todo remove the product from cart
const RemoveFromCart = async (plantId) => {
	const url = `http://localhost:8088/plants/getall?key=TQqqoA/${plantId}`;
	const res = await fetch(url, {
		method: "DELETE",
		headers: {
			"Content-Type": "application/json",
		},
	});
	getCartDataFromDatabase();
};

// todo move the element into the favorite
const MoveToFavorite = async (id) => {
	const url = `http://localhost:8088/plants/getall?key=TQqqoA/${plantId}`;
	const res = await fetch(url);
	const data = await res.json();

	if (data) RemoveFromCart(plantId);
	//todo adding the data in fav
	addToFavorite(data);
};

const addToFavorite = async (data) => {
	const url = `http://localhost:8088/plants/getall?key=TQqqoA`;
	const res = await fetch(url, {
		method: "POST",
		body: JSON.stringify(data),
		headers: {
			"Content-Type": "application/json",
		},
	});
};

// todo finding the total price;
let add = 0;
const getTotalPrice = (data) => {
	add = data.reduce((acc, el) => {
		let val = el.plantCost.split(".")[1].split(",");
		console.log("val: ", val);
		if (val[1]) {
			return acc + +(val[0] + val[1] || 0);
		} else {
			return acc + +val[0];
		}
	}, 0);
	document.querySelector(
		"#subtotal>span+span",
	).innerHTML = `Rs. ${add.toLocaleString("en-IN")}`;
	charges(0, add);
};

// todo change the price when user inrease the quantity
let prevQty = 1;
const SelectItemQty = (plantCost, index) => {
	let qtyVal = document.querySelector(`.qty-${index}`).value;

	//FINDING THE PRICE
	price = plantCost.split(".")[1].trim().split(",");
	price = plantCost[0] + price[1];
	add -= +plantCost * prevQty;
	add += +price * +qtyVal;
	console.log("add: ", add);

	charges(discount, add);
	prevQty = +qtyVal;

	showValue = (+price * +qtyVal).toLocaleString("en-IN");
	document.querySelector(
		"#subtotal>span+span",
	).innerHTML = `Rs. ${add.toLocaleString("en-IN")}`;
	document.querySelector(`#p-${index}>p`).innerHTML = `Rs. ${showValue}`;
};

// todo taking the promocode throw prompt
let discount = 0;
document.querySelector("#promo_code").onclick = () => {
	let discountSpan = document.querySelector("#discount>span+span");
	let val = prompt("Please Enter The promoCode");
	if (val === "SEPHORA30") {
		discount = +(add * 0.3).toFixed(2);
		discountSpan.innerHTML = `- Rs. ${discount.toLocaleString("en-IN")}`;
		discount = add - discount;
		charges(discount, add);
	}
};

//todo finding the best amount fo user
const charges = (discount, add) => {
	//
	let deliveryCharge = document.querySelector("#delivery_charges>span+span");
	let gst = document.querySelector("#gst>span+span");
	let totalPrice = document.querySelector("#total>span+span");

	//finding the gst
	let gstPrice = +((discount || add) * 0.18).toFixed(2);
	deliveryCharge.innerHTML = `Rs. 40`;
	gst.innerHTML = `Rs. ${gstPrice}`;
	totalPrice.innerHTML = `Rs. ${(
		(discount || add) +
		40 +
		gstPrice
	).toLocaleString("en-IN")}`;
};

// TODO redirect to Sale when click the see more

document.querySelector(".shop_more").onclick = () => {
	window.location.href = "sale.html";
};

let overlay = document.querySelector("#overlay");
let checkoutBTN = document.querySelector(".checkout");
checkoutBTN.onclick = (event) => {
	console.log("event: ", event);
	let addressBar = document.querySelector("#AddressBody_Pr");
	if (AddressData) {
		let amountDetails = { discount, add };
		localStorage.setItem("amountDetails", JSON.stringify(amountDetails));
		window.location.href = "payment.html";
	} else {
		addressBar.style.display = "block";
		overlay.style.display = "block";
	}
};

// todo close address bar by clicking on the overlay
overlay.onclick = () => {
	closeAddressBar();
};

//todo close address bar by clicking on the backbutton
let backToCart = document.querySelector("#backToCart");
backToCart.onclick = () => {
	closeAddressBar();
};

// todo close the AddressBar ()
const closeAddressBar = () => {
	let addressBar = document.querySelector("#AddressBody_Pr");
	addressBar.style.display = "none";
	overlay.style.display = "none";
};
