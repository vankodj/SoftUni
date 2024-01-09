function solve(n, input){
   let arr = [];
   for (let index = 0; index < n; index++) {

    arr.push(input[index]);
   }
   let output = "";
   for (let i = arr.length-1; i >=0; i--) {
    output += arr[i] + ` `;
    
   }
    console.log(output);
   

}
solve(3, [10, 20, 30, 40, 50]);