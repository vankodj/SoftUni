function attachEvents() {
   const inputName = document.querySelector("#controls > div:nth-child(1) > input[type=text]");
   const inputMessage = document.querySelector("#controls > div:nth-child(2) > input[type=text]");
   const sendBtn = document.getElementById("submit");
   const refreshBtn = document.getElementById("refresh");
   const textArea = document.getElementById("messages");
   const url = "http://localhost:3030/jsonstore/messenger";
   sendBtn.addEventListener("click",send);
   function send(){
    let author = inputName.value;
    let content = inputMessage.value;
    const httpHeather = {
        method:"POST",
        body: JSON.stringify({author,content})
    }
    fetch(url,httpHeather)
    .then((res)=> res.json())
    .then(()=>{
    inputName.value = "";
    inputMessage.value = "";
    }).catch((err)=> {
        console.error(err);
    })
   }
   refreshBtn.addEventListener("click",refresh);
   function refresh(){
    fetch(url)
    .then((res)=> res.json())
    .then((data)=>{
        let result = []

        for (const msg of Object.values(data)) {
            result.push(`${msg.author}: ${msg.content}`)
        }

        messages.textContent = result.join('\n')
    })
   }
}

attachEvents();