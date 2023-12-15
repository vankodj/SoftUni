window.addEventListener("load", solve);


function solve() {
const main = document.getElementById("main");
const formContainer = document.querySelector("#main > div.form-wrapper");
const sideContainer = document.getElementById("side-wrapper");
const firstNameInput = document.getElementById("first-name");
const lastNameInput = document.getElementById("last-name");
const ageInput = document.getElementById("age");
const storyTitleInput = document.getElementById("story-title");
const genreInput = document.getElementById("genre");
const previewList = document.getElementById("preview-list");
const storyInput = document.getElementById("story");
const publishBtn = document.getElementById("form-btn");

publishBtn.addEventListener("click",publish);

function publish(){
let firstName = firstNameInput.value;
let lastName = lastNameInput.value;
let age = ageInput.value;
let title = storyTitleInput.value;
let story = storyInput.value;
let genre = genreInput.value;
const li = document.createElement("li");

if(firstName === "" || lastName === "" || age === "" || title === "" || story === ""
|| genre === ""){
  return;
}

const article = document.createElement("article");
const articleBtn = document.createElement("article");
const h4 = document.createElement("h4");
const ageParagraph = document.createElement("p");
const titleParagraph = document.createElement("p");
const genreParagraph = document.createElement("p");
const storyParagraph = document.createElement("p");
const saveBtn = document.createElement("button");
const editBtn = document.createElement("button");
const deleteBtn = document.createElement("button");

li.classList.add("story-info");
saveBtn.classList.add("save-btn");
editBtn.classList.add("edit-btn");
deleteBtn.classList.add("delete-btn");

h4.textContent = `Name: ${firstName} ${lastName}`;
ageParagraph.textContent = `Age: ${age}`;
titleParagraph.textContent = `Title: ${title}`;
genreParagraph.textContent = `Genre: ${genre}`;
storyParagraph.textContent = story;
saveBtn.textContent = "Save Story";
editBtn.textContent = "Edit Story";
deleteBtn.textContent = "Delete Story";

article.appendChild(h4);
article.appendChild(ageParagraph);
article.appendChild(titleParagraph);
article.appendChild(genreParagraph);
article.appendChild(storyParagraph);
articleBtn.appendChild(saveBtn);
articleBtn.appendChild(editBtn);
articleBtn.appendChild(deleteBtn);
li.appendChild(article);
li.appendChild(articleBtn);
previewList.appendChild(li);

firstNameInput.value = "";
lastNameInput.value = "";
ageInput.value = "";
storyTitleInput.value = "";

storyInput.value = "";
publishBtn.setAttribute("disabled",true);

editBtn.addEventListener("click",editStory);
function editStory(){
  
  firstNameInput.value = firstName;
  lastNameInput.value = lastName;
  ageInput.value = age;
  storyTitleInput.value = title;
 
  storyInput.value = story;
  li.remove();
  publishBtn.removeAttribute("disabled");
  
}
saveBtn.addEventListener("click",saveStory);
function saveStory(){
  main.innerHTML = "";
  let h1 = document.createElement("h1");
  h1.textContent = "Your scary story is saved!";
  main.appendChild(h1);
}
deleteBtn.addEventListener("click",deleteStory);
function deleteStory(){
  li.remove();
  publishBtn.removeAttribute("disabled");
}
}

}