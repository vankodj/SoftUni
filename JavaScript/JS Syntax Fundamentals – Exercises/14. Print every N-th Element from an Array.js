function solve(numbers, step){
let array = [];
    for (let i = 0; i < numbers.length; i += step) {
    
        array.push(numbers[i]);
}
return array;
}
solve(['1', '2', '3', '4', '5'], 6);