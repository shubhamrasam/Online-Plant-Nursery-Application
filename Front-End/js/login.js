
let btn=document.getElementById("btn")
btn.onclick=()=>{
    LogIn();
}

let LogIn=async()=>{
    try{
        let custdata={
            customerMobileNumber:document.querySelector(".mobile-number").value,
            customerPassword:document.querySelector(".password").value
        }
        let res=await fetch(`http://localhost:8088/customer/login`,{
            method:'POST',
            body:JSON.stringify(custdata),
            headers:{
                'Content-Type':'application/json'
            }
           
        })

       // let data=await res.json()
        console.log(res.headers)
        

    }catch(error){
        console.log("error:",error)
    }
}