function addItem() {
    const liItems = document.getElementById("items");
    const newItem = document.getElementById("newItemText");
    const newLi = document.createElement("li");
    newLi.textContent = newItem.value;
    liItems.appendChild(newLi);
    newItem.value = "";

}