function shopList(input){
let products = input.shift().split("!");
for (const line of input) {
    let tokens = line.split(" ");
    let command = tokens[0];
    switch(command){
        case "Unnecessary":
            let productToRemove = tokens[1];
            if(products.includes(productToRemove)){
                const index = products.indexOf(productToRemove);
                products.splice(index,1);
                }
                break;
        case "Urgent":
            let productToAdd = tokens[1];
            if(!products.includes(productToAdd)){
            products.unshift(productToAdd);
            
            }
            break;
        case "Correct":
            let oldItem = tokens[1];
            let newItem = tokens[2];
            if(products.includes(oldItem)){
            products.splice(products.indexOf(oldItem), 1, newItem);
            }
            break;
        case "Rearrange":
            let productToMove = tokens[1];
            if(products.includes(productToMove)){
                const index = products.indexOf(productToMove);
                products.splice(index,1);
                products.push(productToMove);
                
            }
            break;
        case "Go":
            let nextWord = tokens[1];
            if(nextWord === "Shopping"){
                return;
            }
            break;
    }

}
console.log(products.join(", "));

}
shopList(["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"]);