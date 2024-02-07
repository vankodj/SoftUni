function attachEvents() {
  const loadAllBooksBtn = document.getElementById("loadBooks");
  const BASE_URL = "http://localhost:3030/jsonstore/collections/books/";
  const booksContainer = document.querySelector("table > tbody");
  const inputTitle = document.querySelector("#form > input[type=text]:nth-child(3)");
  const inputAuthor = document.querySelector("#form > input[type=text]:nth-child(5)");
  const submitBtn = document.querySelector("#form > button");
  const formHeader = document.querySelector("#form > h3");
 
  let allBooks = {};
  let editBookId = null;
  loadAllBooksBtn.addEventListener("click",loadBooks);
  submitBtn.addEventListener("click" ,create);
 

 async function loadBooks(){
    booksContainer.innerHTML = "";
    const bookRes =  await fetch(BASE_URL);
    let bookData = await bookRes.json();
      allBooks = bookData;
      for (const bookId in bookData) {
       const {author, title} = bookData[bookId];
       const tableRow = document.createElement("tr");
       const titleColumn = document.createElement("td");
       const authorColumn = document.createElement("td");
       const buttonsColumn = document.createElement("td");
       const editBtn = document.createElement("button");
       const deleteBtn = document.createElement("button");
       editBtn.textContent = "Edit";
       deleteBtn.textContent = "Delete";
       deleteBtn.id = bookId;
       
       editBtn.addEventListener("click",()=>{
        editBookId = bookId;
        formHeader.textContent = "Edit FORM";
        submitBtn.textContent = "Save";
        inputTitle.value = title;
        inputAuthor.value = author;
       });
       deleteBtn.addEventListener("click",deleteBookHandler);
       buttonsColumn.appendChild(editBtn);
       buttonsColumn.appendChild(deleteBtn);
       titleColumn.textContent = title;
       authorColumn.textContent = author;
       tableRow.appendChild(titleColumn);
       tableRow.appendChild(authorColumn);
       tableRow.appendChild(buttonsColumn);
       booksContainer.appendChild(tableRow);
      }
       }
 function create(){
  const title = inputTitle.value;
  const author = inputAuthor.value;
  const httpHeathers = {
    method:"POST",
    body: JSON.stringify({title, author})
  }
  let url = BASE_URL;
  if(formHeader.textContent === "Edit FORM"){
   httpHeathers.method = "PUT";
   url += editBookId;
   }
  
  fetch(url,httpHeathers)
  .then((res)=> res.json())
  .then((data)=>{
    loadBooks();
    if(submitBtn.textContent === "Edit FORM"){
    formHeader.textContent = "FORM";
    submitBtn.textContent = "Submit";
    }
    inputTitle.value = "";
    inputAuthor.value = "";
  })


 }
async function deleteBookHandler(){
  const id = this.id;
  const httpHeathers = {
    method: "DELETE"
  };
 await fetch(BASE_URL + id,httpHeathers);
 loadBooks();
}

}

attachEvents();