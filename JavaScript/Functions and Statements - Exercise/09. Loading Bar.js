function loadingBar(num){
let loading = "";
    for (let i = 10; i <= num; i+=10) {
    loading += "%";
    
}
for (let j = num; j < 100; j+=10) {
    loading += ".";
    
}
if(loading === "%%%%%%%%%%"){
    console.log("100% Complete!");
    console.log(`[${loading}]`);
}else{
    console.log(`${num}% [${loading}]`);
    console.log("Still loading...");
}

}
loadingBar(100);