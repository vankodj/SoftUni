function solve(typoeOfFruit,weight,pricePerKg){
    let kilograms = weight/1000;
        let price = kilograms * pricePerKg;
    console.log(`I need $${price.toFixed(2)} to buy ${kilograms.toFixed(2)} kilograms ${typoeOfFruit}.`);
    }
solve('orange', 2500, 1.80);