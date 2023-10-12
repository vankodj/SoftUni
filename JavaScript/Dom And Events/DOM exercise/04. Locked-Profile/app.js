function lockedProfile() {
   const btn = Array.from(document.querySelectorAll("#main > div > button"));
   
  
   btn.forEach((b) =>{ b.addEventListener("click",show);

   });
   function show(e){
   let btn1 = e.currentTarget;
   let currentSection = btn1.parentElement;
   let children = Array.from(currentSection.children);
   let hiddenDiv = children[9];
   let radioInput = children[4];
  if(radioInput.checked){
   if(btn1.textContent==="Show more"){
    hiddenDiv.style.display = "block";
    btn1.textContent = "Hide it";
   }else{
    hiddenDiv.style.display = "none";
    btn1.textContent = "Show more";
   }
   }
   }
}