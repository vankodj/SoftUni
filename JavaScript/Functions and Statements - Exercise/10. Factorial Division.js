function factorialDivision(num1,num2){
let factorial1 = 1;
let factorial2 = 1;
    for (let i = num1; i > 0; i--) {
   factorial1 *= i;
       
    
}
for (let j = num2; j > 0; j--) {
    factorial2 *= j;    
}

let result = factorial1/factorial2;
console.log(result.toFixed(2));
}
factorialDivision(6,2);