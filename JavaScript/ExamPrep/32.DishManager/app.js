window.addEventListener("load", solve);

function solve() {
  const ulInProgress = document.getElementById("in-progress");
  const firstNameInput = document.getElementById("first-name");
  const lastNameInput = document.getElementById("last-name");
  const ageInput = document.getElementById("age");
  const genderSelect = document.getElementById("genderSelect");
  const dishDescription = document.getElementById("task");
  const submitBtn = document.getElementById("form-btn");
  const progressCount = document.getElementById("progress-count");
  const finished = document.getElementById("finished");
  const clearBtn = document.getElementById("clear-btn");
  let information = [];

   let count = 0;
  submitBtn.addEventListener("click",submitDish);
  clearBtn.addEventListener("click",clearInfo);

  function submitDish(){
 
  const firstName = firstNameInput.value;
  const lastName = lastNameInput.value;
  const age = ageInput.value;
  const gender = genderSelect.value;
  const description = dishDescription.value;

  if(firstName === "" || lastName === "" || age === "" || description === ""){
    return;
  }
  
  const li = document.createElement("li");
  const article = document.createElement("article");
  const h4Name = document.createElement("h4");
  const pGenderAge = document.createElement("p");
  const pDescription = document.createElement("p");
  const editBtn = document.createElement("button");
  const completeBtn = document.createElement("button");
  

  li.classList.add("each-line");
  editBtn.classList.add("edit-btn");
  completeBtn.classList.add("complete-btn");

  h4Name.textContent = `${firstName} ${lastName}`;
  pGenderAge.textContent = `${gender}, ${age}`;
  pDescription.textContent = `Dish description: ${description}`;
  editBtn.textContent = "Edit";
  completeBtn.textContent = "Mark as complete";

  editBtn.addEventListener("click",editInfo);
  completeBtn.addEventListener("click",finishedInfo);
 
  information.push(firstName);
  information.push(lastName);
  information.push(age);
  information.push(gender);
  information.push(description);

  article.appendChild(h4Name);
  article.appendChild(pGenderAge);
  article.appendChild(pDescription);
  li.appendChild(article);
  li.appendChild(editBtn);
  li.appendChild(completeBtn);
  ulInProgress.appendChild(li);
  
  firstNameInput.value = "";
  lastNameInput.value = "";
  ageInput.value = "";
  dishDescription.value = "";
  count++;
  progressCount.textContent = count;
  }

  function editInfo(e){
    const parent = e.currentTarget.parentNode;
    firstNameInput.value = information[0];
  lastNameInput.value = information[1];
  ageInput.value = information[2];
  genderSelect.value = information[3];
  dishDescription.value = information[4];
  parent.remove();
  count--;
  progressCount.textContent = count;
  }

function finishedInfo(e){
  const parent = e.currentTarget.parentNode;
  finished.appendChild(parent);
  const editBtn = parent.children[1];
  const completeBtn = parent.children[2];
  editBtn.remove();
  completeBtn.remove();
  count--;
  progressCount.textContent = count;
  
  
}

function clearInfo(){
  finished.innerHTML = "";
}

}
