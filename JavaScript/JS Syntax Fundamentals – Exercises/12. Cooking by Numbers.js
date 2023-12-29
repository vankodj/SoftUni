function solve(num, ...operations){
let result = 0;
let number = Number(num);
    operations.forEach(element => {
    switch(element){
        case "chop":
        number /= 2;
        break;
        case "dice":
            number = Math.sqrt(number);
        break;
        case "spice":
            number++;
            break;
            case "bake":
                number *= 3;
                break;
                case "fillet":
                    number -= number * 0.2;
                    break; 
    }
    console.log(number);
});

}
solve('9', 'dice', 'spice', 'chop', 'bake','fillet');