function extractText() {
   const liItems = Array.from(document.querySelectorAll("#items > li"));
   const textArea = document.getElementById("result");
 

   liItems.forEach((li) =>{ 
    textArea.textContent += li.textContent + "\n";
   });
}