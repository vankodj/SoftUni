function attachEvents() {
  window.addEventListener("load", listStudents);
  const BASE_URL = "http://localhost:3030/jsonstore/collections/students";
  const tbody = document.querySelector("#results > tbody");
  const submitBtn = document.getElementById("submit");
  const firstNameInput = document.querySelector("#form > div.inputs > input[type=text]:nth-child(1)");
  const lastNameInput = document.querySelector("#form > div.inputs > input[type=text]:nth-child(2)");
  const facultyNumberInput = document.querySelector("#form > div.inputs > input[type=text]:nth-child(3)");
  const gradeInput = document.querySelector("#form > div.inputs > input[type=text]:nth-child(4)");

function listStudents(){
  fetch(BASE_URL)
  .then((res)=> res.json())
  .then((data)=>{
    
    for (const key in data) {
     const {firstName,lastName,facultyNumber,grade} = data[key];
     const tr = document.createElement("tr");
     const thName = document.createElement("th"); 
     const thLastName = document.createElement("th"); 
     const thFacultyNum = document.createElement("th"); 
     const thGrage = document.createElement("th"); 
     thName.textContent = firstName;
     thLastName.textContent = lastName;
     thFacultyNum.textContent = facultyNumber;
     thGrage.textContent = Number(grade);
     tr.appendChild(thName);
     tr.appendChild(thLastName);
     tr.appendChild(thFacultyNum);
     tr.appendChild(thGrage);
     tbody.appendChild(tr);
    }
    
  }).catch((err)=>{
    console.error(err);
  })
}
submitBtn.addEventListener("click",submit);
function submit(){
  let firstName = firstNameInput.value;
  let lastName = lastNameInput.value;
  let facultyNumber = facultyNumberInput.value;
  let grade = gradeInput.value;
  const httpHeather = {
    method: "POST",
    body: JSON.stringify({firstName,lastName,facultyNumber,grade})
  }
  fetch(BASE_URL,httpHeather)
  .then((res)=>res.json())
  .then((data)=>{
    firstNameInput.value = "";
    lastNameInput.value = "";
    facultyNumber.value = "";
    gradeInput.value = "";
    
  })
}

}

attachEvents();