function solve() {
  const output = document.getElementById("output");
  const input = document.getElementById("input");
  let sentences = input.value.split(".");
  sentences.pop();
 while(sentences.length >0) {
   let sentence = sentences.splice(0,3).map((p) => p.trimStart());
  const newParagraph = document.createElement("p");
  newParagraph.textContent = sentence.join(".")+ ".";
  output.appendChild(newParagraph);
 }


}