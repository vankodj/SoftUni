function songs(array){
class Song{
    constructor(typeList, name, time){
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }
}
let songs = [];
let numberOfSongs = array.shift();
let typeOfSong = array.pop();


for (let i = 0; i < numberOfSongs; i++) {
    let [type, name, time] = array[i].split("_");
    let song = new Song(type, name, time);
  
    songs.push(song);
    
}
if(typeOfSong === "all"){
    songs.forEach((e) => console.log(e.name));
}else{
    let filtered = songs.filter((f) => f.typeList === typeOfSong);
    filtered.forEach((e) => console.log(e.name));
}
}
songs([4,

    'favourite_DownTown_3:14',
    
    'listenLater_Andalouse_3:24',
    
    'favourite_In To The Night_3:58',
    
    'favourite_Live It Up_3:48',
    
    'listenLater']);