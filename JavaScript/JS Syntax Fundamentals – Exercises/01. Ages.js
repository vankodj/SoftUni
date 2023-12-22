function solve(age){
let category = "";
if (age >=0 && age <3) {
    category = "baby";
}else if(age >=3 && age <14){
category = "child";
}else if(age >=14 && age <20){
category = "teenager";
}else if(age >=20 && age <66){
category = "adult";
}else if(age >=66){
category = "elder";
}else{
    category = "out of bounds";
}
console.log(category);
}
solve(20);