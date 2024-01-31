 function getInfo() {
   const stopId = document.getElementById("stopId");
   const stopIdValue = stopId.value;
   const busesContainer = document.getElementById("buses");
   const stopName = document.getElementById("stopName");
   const BASE_URL = "http://localhost:3030/jsonstore/bus/businfo/";
   busesContainer.innerHTML = "";
   fetch(`${BASE_URL}${stopIdValue}`)
   .then((res)=> res.json())
   .then((data)=>{
    const {name, buses} = data;
    stopName.textContent = name;
    
    for(const bus in buses) {
        const li = document.createElement("li");
        li.textContent = `"Bus ${bus} arrives in ${buses[bus]} minutes`;
        busesContainer.appendChild(li);
    }
})
    .catch((err)=>{
    stopName.textContent = "Error";
   }
   )
}