window.addEventListener('load', solve);

function solve() {
const firstNameInput = document.getElementById("first-name");
const lastNameInput = document.getElementById("last-name");
const dateInInput = document.getElementById("date-in");
const dateOutInput = document.getElementById("date-out");
const peopleCountInput = document.getElementById("people-count");
const nextBtn = document.getElementById("next-btn");
const infoListUl = document.querySelector("#info-reservations > div > div > ul");
const confirmListUl = document.querySelector("#confirm-reservations > div > div > ul");
const verification = document.getElementById("verification");
let infoArray = [];

nextBtn.addEventListener("click",nextStep);

function nextStep(event){
   if(event){
    event.preventDefault();
   }
   
   const firstName = firstNameInput.value;
   infoArray.push(firstName);
   const lastName = lastNameInput.value;
   infoArray.push(lastName);
   const dateIn = dateInInput.value;
   infoArray.push(dateIn);
   const dateOut = dateOutInput.value;
   infoArray.push(dateOut);
   const peopleCount = peopleCountInput.value;
   infoArray.push(peopleCount);


   if(firstName ==="" || lastName === "" || dateIn === "" || dateOut === "" 
   || peopleCount === "" || dateIn > dateOut){
    return;
   }

   const li = document.createElement("li");
   const article = document.createElement("article");
   const h3Name = document.createElement("h3");
   const pDateIn = document.createElement("p");
   const pDateOut = document.createElement("p"); 
   const pCountPeople = document.createElement("p");
   const editBtn = document.createElement("button");
   const continueBtn = document.createElement("button");


   li.classList.add("reservation-content");
   editBtn.classList.add("edit-btn");
   continueBtn.classList.add("continue-btn");

   h3Name.textContent = `Name: ${firstName} ${lastName}`;
   pDateIn.textContent = `From date: ${dateIn}`;
   pDateOut.textContent = `To date: ${dateOut}`;
   pCountPeople.textContent = `For ${peopleCount} people`;
   editBtn.textContent = "Edit";
   continueBtn.textContent = "Continue";

   editBtn.addEventListener("click",editInfo);
   continueBtn.addEventListener("click",continueInfo);

   article.appendChild(h3Name);
   article.appendChild(pDateIn);
   article.appendChild(pDateOut);
   article.appendChild(pCountPeople);
   li.appendChild(article);
   li.appendChild(editBtn);
   li.appendChild(continueBtn);
   infoListUl.appendChild(li);

   firstNameInput.value = "";
   lastNameInput.value = "";
   dateInInput.value = "";
   dateOutInput.value = "";
   peopleCountInput.value = "";  

   nextBtn.setAttribute("disabled",true);
}

function editInfo(e){
    const parent = e.currentTarget.parentNode;
    firstNameInput.value = infoArray[0];
    lastNameInput.value = infoArray[1];
    dateInInput.value = infoArray[2];
    dateOutInput.value = infoArray[3];
    peopleCountInput.value = infoArray[4];
    nextBtn.disabled = false;
    parent.remove();
}

function continueInfo(e){
    const parent = e.currentTarget.parentNode;
    confirmListUl.appendChild(parent);
    
    let confirmBtn = parent.children[1];
    let cancelBtn = parent.children[2];
   
    confirmBtn.classList.remove("edit-btn");
    cancelBtn.classList.remove("continue-btn");
    confirmBtn.classList.add("confirm-btn");
    cancelBtn.classList.add("cancel-btn");
   
    confirmBtn.textContent = "Confirm";
    cancelBtn.textContent = "Cancel";
   
    confirmBtn.removeEventListener("click",editInfo);
    confirmBtn.addEventListener("click",confirmInfo);
    cancelBtn.removeEventListener("click",continueInfo);
    cancelBtn.addEventListener("click",cancelInfo);
  
}

function confirmInfo(e){
    const parent = e.currentTarget.parentNode;
    verification.classList.add("reservation-confirmed");
  verification.textContent = "Confirmed.";
  nextBtn.disabled = false;
  parent.remove();
}

function cancelInfo(e){
    const parent = e.currentTarget.parentNode;
    verification.classList.add("reservation-cancelled");
  verification.textContent = "Cancelled.";
  nextBtn.disabled = false;
  parent.remove();
}

 }



    
    
