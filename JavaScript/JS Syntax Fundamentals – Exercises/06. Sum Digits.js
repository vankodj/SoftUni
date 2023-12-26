function solve(num){
let sum = 0;
while(num>0){
    let lastDigit = num % 10;
    sum += lastDigit;
    num = Math.floor(num /10);
}
console.log(sum);
}
solve(245678);