function addItem() {
    const newText = document.getElementById("newItemText");
    const newValue = document.getElementById("newItemValue");
    const menu = document.getElementById("menu");
    const button = document.querySelector("body > article > input[type=button]:nth-child(6)");
    const option = document.createElement("option");
     option.textContent = newText.value;
        option.value = newValue.value;
        menu.appendChild(option);
        newText.value = "";
        newValue.value = "";

}