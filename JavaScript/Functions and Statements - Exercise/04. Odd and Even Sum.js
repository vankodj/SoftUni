function oddAndEvenSum(numbers){
let textNum = numbers.toString();
let array = textNum.split("");
 
    let oddSum = 0;
let evenSum = 0;
    for (let i = 0; i < array.length; i++) {
    if (array[i] % 2 ===0) {
       
        evenSum += Number(array[i]);
    }else{
        oddSum += Number(array[i]);
    }
    
}
    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

}
oddAndEvenSum(3495892137259234);