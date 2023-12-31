function solve(names){

 let sorted = [...names].sort((aNum,bNum)=> {
    let result = aNum.localeCompare(bNum);
 return result;
})

for (let i = 0; i < sorted.length; i++) {
   console.log(`${i+1}.${sorted[i]} `)
    
}

}
solve(["John", "Bob", "Christina", "Ema"]);