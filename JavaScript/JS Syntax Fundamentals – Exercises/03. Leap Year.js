function solve(year){
let isLeap = "";
if(year % 4 === 0 && year % 100 !==0 || year % 400 === 0){
isLeap = "yes"; 
}else{
    isLeap = "no";
}
console.log(isLeap);
}
solve(2000);