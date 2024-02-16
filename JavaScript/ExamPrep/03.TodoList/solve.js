// TODO
function attachEvents() {
    const titleInput = document.getElementById("title"); 
    const addBtn = document.getElementById("add-button");
    const loadBtn = document.getElementById("load-button");
    const BASE_URL = "http://localhost:3030/jsonstore/tasks/";
    const todoList = document.getElementById("todo-list");
    
    loadBtn.addEventListener("click",loadTasks);
    addBtn.addEventListener("click",addTitle);

    function loadTasks(event){
       if(event){
        event.preventDefault();
       }
        todoList.innerHTML = "";
    fetch(BASE_URL)
    .then((res)=> res.json())
    .then((data)=>{
       for (const key in data) {
        let {name, _id} = data[key];
        let li = document.createElement("li");
        let span = document.createElement("span");
        let removeBtn = document.createElement("button");
        let editBtn = document.createElement("button");
       
        span.textContent = name;
        removeBtn.textContent = "Remove";
        editBtn.textContent = "Edit";
        li.id = _id;

        li.appendChild(span);
        li.appendChild(removeBtn);
        li.appendChild(editBtn);

        todoList.appendChild(li);

        removeBtn.addEventListener("click",removeTasks);
        editBtn.addEventListener("click",editTasks);

       

    }
}).catch((err)=>{
        console.log(err);
    })
   
    }

     function addTitle(event){
        
        event.preventDefault();
        
        let name = titleInput.value;
        let httpHeader = {
            method: "POST",
            body: JSON.stringify({name})
        }
        
        fetch(BASE_URL, httpHeader)
        .then(()=>{           

            loadTasks();
            titleInput.value = "";
        }).catch((err)=>{
            console.error(err);
        });
    }
 
    function removeTasks(event){
        const liParent = event.currentTarget.parentNode;
        const id = liParent.id;

        httpHeader = {
            method: "DELETE"
        }
        fetch(BASE_URL + id ,httpHeader)
        .then((res)=>res.json())
        .then(()=>{
            loadTasks();
        }).catch((err)=>{
            console.error(err);
        })
    }
    function editTasks(event){
        const liParent = event.currentTarget.parentNode;
        const [span,_removeBtn,editBtn] = Array.from(liParent.children);
        const editInput = document.createElement("input");
        const submitBtn = document.createElement("button");
        submitBtn
        editInput.value = span.textContent;
        span.remove();
        editBtn.remove();
        submitBtn.textContent = "Submit";
        liParent.prepend(editInput);
        liParent.appendChild(submitBtn);
        submitBtn.addEventListener("click",submitTasks);

    }

    function submitTasks(event){
        const liParent = event.currentTarget.parentNode;
        const [editInput,_removeBtn,submitBtn] = Array.from(liParent.children);
        let edit = editInput.value;
        const id = liParent.id;
        const httpHeader = {
            method: "PATCH",
            body:JSON.stringify({name: edit})
        }
     fetch(BASE_URL+id,httpHeader)
     .then((res)=>res.json())
     .then((data)=> {
        loadTasks();
     })
    }
}
    
    
attachEvents();
