function solve(string, text){
    
    let word = string.split(", ");
   let array = text.split(" ");
   
for (let i = 0; i < array.length; i++) {
   for (let j = 0; j < word.length; j++) {
    let element = word[j];
    
   
    if(array[i].includes("*")){
        if (array[i].length === element.length) {
            array[i] = element;
        }
    }
}
};



    console.log(array.join(" "));

}
solve('great, learning', 'softuni is ***** place for ******** new programming languages');