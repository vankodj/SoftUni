function addItem() {
    const liItems = document.getElementById("items");
    const newItem = document.getElementById("newItemText");
    const newLi = document.createElement("li");
    const anchor = document.createElement("a");
    anchor.textContent = "[Delete]";
    anchor.setAttribute("href","#");
    newLi.textContent = newItem.value;
    liItems.appendChild(newLi);
    newLi.appendChild(anchor);
    newItem.value = "";
    anchor.addEventListener("click", deleteRow);


function deleteRow(e){
    const liItem = e.currentTarget.parentElement;
    liItem.remove();
}
}