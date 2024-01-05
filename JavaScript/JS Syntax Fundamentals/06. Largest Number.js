function solve(firstNum,secondNum,thirdNum){
    if(firstNum > secondNum && firstNum > thirdNum){
        console.log(`The largest number is ${firstNum}.`);
    }else if (secondNum > firstNum && secondNum > thirdNum){
       console.log(`The largest number is ${secondNum}.`);
    }
    else if (thirdNum > firstNum && secondNum < thirdNum){
        console.log(`The largest number is ${thirdNum}.`);
     }
}
solve(3,2,1);