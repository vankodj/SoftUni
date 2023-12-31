function solve(numbers){
    let array = [];
    let sorted = [...numbers].sort((aNum,bNum)=> {
        let result = aNum - bNum;
     return result;
    })
   while(sorted.length != 0){
   array.push(sorted.shift());
   array.push(sorted.pop());
   }
   return array;
}
solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);