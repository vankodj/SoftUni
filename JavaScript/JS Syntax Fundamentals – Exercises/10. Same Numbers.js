function solve(num){
    let sum = 0;
    let last = num % 10;
    let same = true;
    while(num>0){
        let lastDigit = num % 10;
        sum += lastDigit;
        if(last !== lastDigit){
            same = false;
        }
        num = Math.floor(num /10);
    }
    console.log(same);
    console.log(sum);
}
solve(2222222);