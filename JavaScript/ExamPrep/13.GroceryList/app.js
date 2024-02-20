function attachEvents(){
    const BASE_URL = "http://localhost:3030/jsonstore/grocery/";
    const tbody = document.getElementById("tbody");
    const loadProductBtn = document.getElementById("load-product");
    const addProductBtn = document.getElementById("add-product");
    const updateProductBtn = document.getElementById("update-product");
    const productInput = document.getElementById("product");
    const countInput = document.getElementById("count");
    const priceInput = document.getElementById("price");
    let products = [];
    let productToEdit = {};

    addProductBtn.addEventListener("click", addProduct);
    loadProductBtn.addEventListener("click" , loadProducts);

    function loadProducts(event){
      if(event){
         event.preventDefault();
      }
      tbody.innerHTML = "";
        fetch(BASE_URL)
        .then((res)=> res.json())
        .then((data)=> {
          
            
            for (const key in data) {
                let {product,count,price,_id} = data[key];
                products.unshift(data[key]);
                
                
                const tr = document.createElement("tr");
                const tdName = document.createElement("td");
                const tdCount = document.createElement("td");
                const tdPrice = document.createElement("td");
                const tdBtn = document.createElement("td");
                const updateBTn = document.createElement("button");
                const deleteBtn = document.createElement("button");
    
                tdName.classList.add("name");
                tdCount.classList.add("count-product");
                tdPrice.classList.add("product-price");
                tdBtn.classList.add("btn");
                updateBTn.classList.add("update");
                deleteBtn.classList.add("delete");

                tdBtn.id = _id;
             
             deleteBtn.addEventListener("click",deleteProduct);
             updateBTn.addEventListener("click",updateEvent);
             
                tdName.textContent = product;
              tdCount.textContent = Number(count);
              tdPrice.textContent = Number(price);
            
              updateBTn.textContent = "Update";
              deleteBtn.textContent = "Delete";
              tdBtn.appendChild(updateBTn);
              tdBtn.appendChild(deleteBtn);
              tr.appendChild(tdName);
              tr.appendChild(tdCount);
              tr.appendChild(tdPrice);
              tr.appendChild(tdBtn);
              tbody.appendChild(tr);
            
            
            }
            

        })
        .catch((err)=>{
            console.error(err);
        })
    }

   function addProduct(event){
     if(event){
        event.preventDefault();
     }
     
     let product = productInput.value;
     let count = countInput.value;
     let price = priceInput.value;
     const httpHeader = {
        method: "POST",
        body:JSON.stringify({product,count,price})
     };
     fetch(BASE_URL,httpHeader)
     .then(()=>{
        loadProducts();
        productInput.value = "";
        countInput.value = "";
        priceInput.value = "";
     }).catch((err)=>{
        console.error(err);
     })
   }

function deleteProduct(e){
  let parentElement = e.currentTarget.parentNode;
  let id = parentElement.id;
  const httpHeader = {
    method: "DELETE"
  }
  fetch(BASE_URL + id,httpHeader)
  .then((res)=>res.json())
  .then(()=>{
    loadProducts();
  }).catch((err)=>{
    console.error(err);
  })
}

function updateEvent(){
    let id = this.parentNode.id;
   
   productToEdit = products.find((p)=>p._id ===id);
  

 updateProductBtn.disabled = false;
 addProductBtn.disabled = true;

productInput.value = productToEdit.product;
countInput.value = productToEdit.count;
priceInput.value = productToEdit.price;
 
 updateProductBtn.addEventListener("click",updateProduct); 
}

function updateProduct(e){

const id = productToEdit._id;

let product = productInput.value;
let count = countInput.value;
let price = priceInput.value;
const httpHeader = {
    method: "PATCH",
    body:JSON.stringify({product,count,price})
}
fetch(BASE_URL + id,httpHeader)
.then((res)=>res.json())
.then(()=>{
    loadProducts();
    productInput.value = "";
    countInput.value = "";
    priceInput.value = "";
    addProductBtn.disabled = false;
    updateProductBtn.disabled = true;
})
}

}
attachEvents();