function pianist(input){
let n = Number(input.shift());
let pieceCollection= {};
let commandParser = {
    "Add": addPiece,
    "Remove": removePiece,
    "ChangeKey": changeKey
}

for (let i = 0; i < n; i++) {
 let [piece,composer,key] = input.shift().split("|");
 pieceCollection[piece] = {composer,key};
}
for (let line of input) {
    if(line==="Stop"){
        break;
    }
    let tokens = line.split("|"); 
    let command = tokens[0];
  commandParser[command](...tokens.slice(1));  
}
for (const piece in pieceCollection) {
    let {composer,key} = pieceCollection[piece];
 
   console.log(`${piece} -> Composer: ${composer}, Key: ${key}`)
}

function addPiece(piece,composer,key){
  if(pieceCollection.hasOwnProperty(piece)){
    console.log(`${piece} is already in the collection!`);
  }else{
    pieceCollection[piece] = {composer,key};
    console.log(`${piece} by ${composer} in ${key} added to the collection!`);
  }
}
function removePiece(piece){
    if(pieceCollection.hasOwnProperty(piece)){
       delete pieceCollection[piece];
       console.log(`Successfully removed ${piece}!`)
      }else{
        console.log(`Invalid operation! ${piece} does not exist in the collection.`);
      }
}
function changeKey(piece, newKey){
   if(pieceCollection.hasOwnProperty(piece)){
    pieceCollection[piece].key = newKey;
    console.log(`Changed the key of ${piece} to ${newKey}!`);
   }else{
    console.log(`Invalid operation! ${piece} does not exist in the collection.`);
   }
}

}


pianist(
    [
        '3',
        'Fur Elise|Beethoven|A Minor',
        'Moonlight Sonata|Beethoven|C# Minor',
        'Clair de Lune|Debussy|C# Minor',
        'Add|Sonata No.2|Chopin|B Minor',
        'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
        'Add|Fur Elise|Beethoven|C# Minor',
        'Remove|Clair de Lune',
        'ChangeKey|Moonlight Sonata|C# Major',
        'Stop'  
      ]
      
)