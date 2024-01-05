function solve(firstNum, secondNum, sign){
    switch(sign){
        case '+':
            console.log(firstNum + secondNum);
            break;
            case '-':
                console.log(firstNum - secondNum);
                break;
                case '*':
                    console.log(firstNum * secondNum);
                    break;
                    case '/':
                        console.log(firstNum / secondNum);
                        break;
                        case '%':
                            console.log(firstNum % secondNum);
                            break;
                            case '**':
                                console.log(firstNum ** secondNum);
                                break;
    }
}
solve(5,6,'+');