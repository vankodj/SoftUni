function solve(numberOfPeople, typeOfPeople, day){
    let singlePrice = 0;
    let totalPrice = 0;
    let price = 0;
    let discount = 0;
    switch(typeOfPeople){
        case "Students":
            if(day === "Friday"){
             singlePrice = 8.45;
            }else if(day === "Saturday"){
                singlePrice = 9.80;
            }else if(day === "Sunday"){
                singlePrice = 10.46;
            }
           if(numberOfPeople >=30){
            price = numberOfPeople * singlePrice;
            totalPrice = price * 0.85;
           }else{
            totalPrice = singlePrice *numberOfPeople;
           }
           break;
           case "Business":
            if(day === "Friday"){
                   singlePrice = 10.90;
               }else if(day === "Saturday"){
                   singlePrice = 15.60;
               }else if(day === "Sunday"){
                   singlePrice = 16;
               }
              if(numberOfPeople >=100){
               totalPrice = (numberOfPeople-10) * singlePrice;
                }else{
                    totalPrice = singlePrice *numberOfPeople;
                }
              break;
              case "Regular":
                if(day === "Friday"){
                    singlePrice = 15;
                }else if(day === "Saturday"){
                    singlePrice = 20;
                }else if(day === "Sunday"){
                    singlePrice = 22.50;
                }
               if(numberOfPeople >=10 && numberOfPeople <=20){
                   price = numberOfPeople * singlePrice;
                   totalPrice = price * 0.95;
                 }else{
                    totalPrice = singlePrice *numberOfPeople;
                 }
               break;
                }
                
               console.log(`Total price: ${totalPrice.toFixed(2)}`);
    
} 
solve(40, "Regular", "Saturday");