function city(town){
for (const key in town) {
   console.log(`${key} -> ${town[key]}`);
        
    }

}
city({ name: "Sofia", area: 492,
    population: 1238438,country: "Bulgaria", postCode: "1000" });