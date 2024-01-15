function phoneBook(array) {
    let people = {};
    for (let iterator of array) {
        let tokens = iterator.split(" ");
        let name = tokens[0];
        let phoneNumber = tokens[1];
        people[name] = phoneNumber;
    }
    for (const key in people) {
        console.log(`${key} -> ${people[key]}`);
            
        }

}
phoneBook(['Tim 0834212554', 'Peter 0877547887', 'Bill 0896543112', 'Tim 0876566344']);