function solve(text){
return text.split(" ").filter((word) => word.startsWith("#") && containsOnlyLetters(word))
.map((word) => word.slice(1)).filter((word) => word !== "").join("\n");

function containsOnlyLetters(word){
return [...word.toLowerCase()].slice(1).map((symbol) => symbol.charCodeAt(0))
.every((charCode) => charCode >=97 && charCode <=122);
     
}
}
solve('Nowadays everyone uses # to tag a #special word in #socialMedia');