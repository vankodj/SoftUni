function solve (start, end){
let sum = 0;
let arr = "";

for (let i = start; i <= end; i++) {
   arr +=i;
   arr += " ";
    sum += i;
    
}

console.log(arr);
console.log(`Sum: ${sum}`);
}
solve(5, 10);