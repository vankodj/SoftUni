function addressBook(array){
 let bookOfAddress = {};
 for (const iterator of array) {
     let [name, address] = iterator.split(":");
     bookOfAddress[name] = address;
 }
 let sorted = Object.keys(bookOfAddress)
.sort((nameA, nameB) => nameA.localeCompare(nameB));

 for (const key of sorted) {
    console.log(`${key} -> ${bookOfAddress[key]}`);
 }
}
addressBook(['Tim:Doe Crossing',

'Bill:Nelson Place',

'Peter:Carlyle Ave',

'Bill:Ornery Rd']);