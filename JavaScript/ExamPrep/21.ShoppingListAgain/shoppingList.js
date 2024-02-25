function shopList(input){
    let products = input.shift().split("!");
    for (const line of input) {
    let tokens = line.split(" ");
    if(line === "Go Shopping"){
        return;
    }
    let command = tokens[0];
    switch(command){
        case "Urgent":
            let itemToAdd = tokens[1];
            if(!products.includes(itemToAdd)){
                products.unshift(itemToAdd);
            }
            break;
            case "Unnecessary":
                let itemToRemove = tokens[1];
                if(products.includes(itemToRemove)){
                    let index = products.indexOf(itemToRemove);
                    products.splice(index,1);
                }
                break;
                case "Correct":
                    let oldItem = tokens[1];
                    let newItem = tokens[2];
                    if(products.includes(oldItem)){
                        products.splice(products.indexOf(oldItem),1,newItem);
                    }
                    break;
                    case "Rearrange":
                        let itemToRearrange = tokens[1];
                        if(products.includes(itemToRearrange)){
                        const index = products.indexOf(itemToRearrange);
                            products.splice(index,1);
                        products.push(itemToRearrange);
                        }
                        break;
    }
   
}

    console.log(products.join(", "));

}
shopList(["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Urgent Tomatoes",
"Correct Potatoes Butter",
"Rearrange Butter",
"Go Shopping!"]
);