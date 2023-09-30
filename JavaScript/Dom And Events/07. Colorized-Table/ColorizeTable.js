function colorize() {
  const btn = document.querySelector("button");
  const evenTd = Array.from(document.querySelectorAll("tbody > tr"));
  
 
    for (let index = 1; index < evenTd.length; index++) {
          if(index % 2 !==0){
    evenTd[index].style.backgroundColor = "teal";
    
  }
}
  }
