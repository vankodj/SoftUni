function create(words) {
   const mainDiv = document.getElementById("content");
  for (const word of words) {
   const div = document.createElement("div");
   const p = document.createElement("p");
   p.textContent = word;
   p.style.display = "none";
   div.appendChild(p);
   mainDiv.appendChild(div);
    
   div.addEventListener("click",visible);
   function visible(e){
      
   p.style.display = "block";
   
   }
}

}
  
   
  

