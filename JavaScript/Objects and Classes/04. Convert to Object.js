function convertToObject(josnString) {
    let obj = JSON.parse(josnString);
    for (const key in obj) {
        console.log(`${key}: ${obj[key]}`);
            
        }
   
}
convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');