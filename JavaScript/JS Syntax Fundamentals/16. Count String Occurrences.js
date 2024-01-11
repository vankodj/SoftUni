function solve(text, word){
let arr = text.split(" ");
let counter = 0;
arr.forEach(element => {
    if (element === word) {
        counter ++;
    }
});
console.log(counter);
}
solve('This is a word and it also is a sentence',
'is')