function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/collections/books/";
  const loadBooksBtn = document.getElementById("loadBooks");
  const submitBtn = document.querySelector("#form > button");
  const bookContainer = document.querySelector("body > table > tbody");
  const titleInput = document.querySelector("#form > input[type=text]:nth-child(3)");
  const authorInput = document.querySelector("#form > input[type=text]:nth-child(5)");
  const formH3 = document.querySelector("#form > h3");
  let editBtnId = null;
  
  loadBooksBtn.addEventListener("click",loadBooks);
  submitBtn.addEventListener("click",submit);


  function loadBooks(){
    bookContainer.innerHTML = "";
   fetch(BASE_URL)
   .then((res)=>res.json())
   .then((data)=>{
    for (const key in data) {
      const {author, title} = data[key];
      
      const tr = document.createElement("tr");
      const titleTd = document.createElement("td");
      const authorTd = document.createElement("td");
      const editBtn = document.createElement("button");
      const deleteBtn = document.createElement("button");
      tr.id = key;
      editBtnId = key;
      titleTd.textContent = title;
      authorTd.textContent = author;
      editBtn.textContent = "Edit";
      deleteBtn.textContent = "Delete";

      editBtn.addEventListener("click",editBook);
      deleteBtn.addEventListener("click",deleteBook);
      
      tr.appendChild(titleTd);
      tr.appendChild(authorTd);
      tr.appendChild(editBtn);
      tr.appendChild(deleteBtn);
      
      bookContainer.appendChild(tr);




    }
   }).catch((err)=>{
    console.error(err);
   })
  }

function submit(){
 let title = titleInput.value;
 let author = authorInput.value;
 const httpHeathers = {
  method: "POST",
  body:JSON.stringify({title,author})
 }
 if(title === "" || author === ""){
  return;
 }
 fetch(BASE_URL,httpHeathers)
 .then((res)=> res.json())
 .then(()=>{
  loadBooks();
  titleInput.value = "";
  authorInput.value = "";
 })

}

function editBook(e){
  const parent = e.currentTarget.parentNode;
  submitBtn.removeEventListener("click",submit);
  submitBtn.textContent = "Save";
  submitBtn.addEventListener("click",saveBook);
formH3.textContent = "Edit FORM";

const titleElement = parent.children[0];
const authorElement = parent.children[1];
const title = titleElement.textContent;
const author = authorElement.textContent;
titleInput.value = title;
authorInput.value = author;

}

function saveBook(e){
 const parent = e.currentTarget.parentNode;
 const title = parent.children[2].value;
 const author = parent.children[4].value;
 const id = editBtnId;

 console.log(id);
 httpHeathers = {
  method: "PUT",
  body:JSON.stringify({title,author})
};
fetch(BASE_URL+id,httpHeathers)
.then((res)=>res.json())
.then(()=>{
  loadBooks();
}).catch((err)=>{
  console.error(err);
})
}

function deleteBook(e){
const parent = e.currentTarget.parentNode;
const id = parent.id;
httpHeathers = {
  method: "DELETE"
}
fetch(BASE_URL+id,httpHeathers)
.then((res)=>res.json())
.then(()=>{
  loadBooks();
}).catch((err)=>{
  console.error(err);
})
}

}

attachEvents();