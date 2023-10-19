function solve() {
   const searchField = document.getElementById("searchField");
   document.querySelector('#searchBtn').addEventListener('click', onClick);
  
  
   function onClick() {
     
      let searchText = searchField.value;
      const rows = Array.from(document.querySelectorAll("tbody tr"));
     
     
     for (const row of rows) {
      
      let text = row.textContent.trim();
      if(row.classList.contains("select")){
         row.classList.remove("select");
      }
      if(text.includes(searchText)){
         row.classList.add("select");
      }
     }
 searchText = "";
   }
}