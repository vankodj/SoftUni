window.addEventListener('load', solve);

function solve() {
   const genreInput = document.getElementById("genre");
   const songNameInput = document.getElementById("name");
   const authorInput = document.getElementById("author");
   const dateInput = document.getElementById("date");
   const addBtn = document.getElementById("add-btn");
   const allHitsContainer = document.querySelector("#all-hits > div");
   const likeCountsContainer = document.querySelector("#total-likes > div > p");
   const savedContainer = document.querySelector("#saved-hits > div");
   let totalLikes = 0;
   
   addBtn.addEventListener("click",addSong);

   function addSong(event){
    if(event){
        event.preventDefault();
    }
    
    if(genreInput.value==="" || songNameInput.value ==="" || authorInput.value ===""
    || dateInput.value === ""){
        return;
    }
    
    const hitsInfoDiv = document.createElement("div");
    const img = document.createElement("img");
    const h2Genre = document.createElement("h2");
    const h2Name = document.createElement("h2");
    const h2Author = document.createElement("h2");
    const h2Date = document.createElement("h2");
    const saveBtn = document.createElement("button");
    const likeBtn = document.createElement("button");
    const deleteBtn = document.createElement("button");
    
    hitsInfoDiv.classList.add("hits-info");
    saveBtn.classList.add("save-btn");
    likeBtn.classList.add("like-btn");
    deleteBtn.classList.add("delete-btn");
    img.src = "./static/img/img.png";
   
    h2Genre.textContent = `Genre: ${genreInput.value}`;    
    h2Name.textContent = `Name: ${songNameInput.value}`;
    h2Author.textContent = `Author: ${authorInput.value}`;
    h2Date.textContent = `Date: ${dateInput.value}`;
    saveBtn.textContent = "Save song";
    likeBtn.textContent = "Like song";
    deleteBtn.textContent = "Delete";

    likeBtn.addEventListener("click",likeSong);
    saveBtn.addEventListener("click",saveSong);
    deleteBtn.addEventListener("click",deleteSong);
   
   
    
    hitsInfoDiv.appendChild(img);
    hitsInfoDiv.appendChild(h2Genre);
    hitsInfoDiv.appendChild(h2Name);
    hitsInfoDiv.appendChild(h2Author);
    hitsInfoDiv.appendChild(h2Date);
    hitsInfoDiv.appendChild(saveBtn);
    hitsInfoDiv.appendChild(likeBtn);
    hitsInfoDiv.appendChild(deleteBtn);

    
    allHitsContainer.appendChild(hitsInfoDiv);

     genreInput.value = "";
     songNameInput.value = "";
     authorInput.value = "";
     dateInput.value = "";
   }

function likeSong(){
    
    this.setAttribute("disabled",true);
    totalLikes++;
    likeCountsContainer.textContent = `Total Likes: ${totalLikes}`;
  
  
}

function saveSong(event){
 const parent = event.currentTarget.parentNode;
 let saveBtn = parent.querySelector("#all-hits > div > div > button.save-btn");
 let likeBtn = parent.querySelector("#all-hits > div > div > button.like-btn");
 saveBtn.remove();
 likeBtn.remove();
 savedContainer.appendChild(parent);

 console.log(saveBtn);
}

function deleteSong(event){
    const parent = event.currentTarget.parentNode;
    parent.remove();
   
}

}