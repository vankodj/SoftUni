function solve(text,word){
let arr = text.split(" "); 
let finalWord = "";
for (let i = 0; i < arr.length; i++) {
    if (arr[i] === word) {
       let newWord = word.split("");
        for (let j = 0; j < newWord.length; j++) {
           finalWord += "*";
            
        }
        console.log(finalWord);
        word = finalWord;
    }
   
    
}
console.log(arr);
}
solve('A small sentence with some words',
'small');