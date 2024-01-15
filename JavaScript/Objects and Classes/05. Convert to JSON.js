function convertToJson(name, lastName, hairColor) {
    let person = {name, lastName, hairColor};
    let stringJson = JSON.stringify(person);
    console.log(stringJson);
}
convertToJson('George', 'Jones', 'Brown')