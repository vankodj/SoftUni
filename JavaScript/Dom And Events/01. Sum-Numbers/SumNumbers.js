function calc() {
   const firstNum = document.getElementById("num1");
   const secondNum = document.getElementById("num2");
   const sumInput = document.getElementById("sum");
   
   let parsedNum1 = Number(firstNum.value);
   let parsedNum2 = Number(secondNum.value);
   sum = parsedNum1 + parsedNum2;
   sumInput.value = sum;
}
