function matrix(num){
(num) => new Array(num).fill(new Array(num).fill(num)).forEach((row) => console.log(row.join(" ")));
}
matrix(3);