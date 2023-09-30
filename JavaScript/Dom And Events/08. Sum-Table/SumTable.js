function sumTable() {
const numbers = Array.from(document.querySelectorAll("body > table > tbody > tr > td:nth-child(2)"));
const sum = document.getElementById("sum");
let middleSum = 0;

for (let index = 0; index < numbers.length; index++) {
    console.log(numbers[index]);
    let parsedNum = Number(numbers[index].textContent);
    middleSum += parsedNum;

}
sum.textContent = middleSum;
}