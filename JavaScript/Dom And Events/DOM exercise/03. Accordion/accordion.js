function toggle() {
    const btn = Array.from(document.getElementsByClassName("button"));
    const hiddenDiv = document.getElementById("extra");
    
    
    btn[0].addEventListener("click" , more);

    function more(e){
       console.log(e.target);
        hiddenDiv.style.display = "block";
        btn.textContent = "Less";
      
      
    }
}