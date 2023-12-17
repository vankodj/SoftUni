function charactersInRange(start,end){
const toChar = (char) => char.charCodeAt(0);
let firstAscii = toChar(start);
let secondAscii = toChar(end);  
let minAscii = Math.min(firstAscii,secondAscii);
let maxAscii = Math.max(firstAscii,secondAscii); 
let arr = [];
for (let i = minAscii + 1; i < maxAscii; i++) {
   arr.push(String.fromCharCode(i));
   
    
}
return arr.join(" ");
}
charactersInRange('a','d');