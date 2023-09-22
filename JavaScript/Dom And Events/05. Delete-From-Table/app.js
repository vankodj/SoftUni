function deleteByEmail() {
    const result = document.getElementById("result");
    const inputText = document.querySelector('input[name="email"]');
    const evenTds = Array.from(document.querySelectorAll("td:nth-child(even)"));
    let emailValue = inputText.value;
    let foundElement = evenTds.find((f) => f.textContent === emailValue);
    if (foundElement) {
        console.log(foundElement);
        result.textContent = "Deleted.";
        foundElement.parentElement.remove();
    }else{
        result.textContent = "Not found.";
    }
}