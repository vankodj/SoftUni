function stringSubstring(parameter, text){
let array = text.split(" ");
let flag = false;
for (let i = 0; i < array.length; i++) {
   let next = array[i].toLowerCase();
    if (next === parameter.toLowerCase()) {
    flag = true;
   }
    
}
if (flag) {
    console.log(parameter);
}
else{
    console.log(`${parameter} not found!`)
}
}
stringSubstring('javascript', 'JavaScript is the best programming language');