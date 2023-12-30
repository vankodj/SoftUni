function solve(array, rotation){
    
    for (let i = 0; i < rotation; i++) {
        let firstElement = array.shift(); 
        array.push(firstElement);
    }
    
    console.log(array.join(" "));

}
solve([51, 47, 32, 61, 21], 2);