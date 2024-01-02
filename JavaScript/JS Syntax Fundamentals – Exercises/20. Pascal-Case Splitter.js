function pascalCase(text){
let array = text.split(/(?=[A-Z])/);
console.log(array.join(", "));
}
pascalCase('SplitMeIfYouCanHaHaYouCantOrYouCan');