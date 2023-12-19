function passwordValidator(word){


const isValidLength = (pass) => pass.length >= 6 && pass.length <= 10;
 const isValidLettersAndDigits = (pass) => /^[A-Za-z0-9]+$/g.test(pass);   
 const isValidHaveAtLeastTwoDigits = (pass) => [...pass.matchAll(/\d/g)].length >=2;
let passIsValid = true;
 if(!isValidLength(word)){
console.log("Password must be between 6 and 10 characters");
passIsValid = false;
}
if(!isValidLettersAndDigits(word)){
    console.log("Password must consist only of letters and digits");
    passIsValid = false;
}
if(!isValidHaveAtLeastTwoDigits(word)){
    console.log("Password must have at least 2 digits");
    passIsValid = false;
}
if(passIsValid){
    console.log("Password is valid");
}
};

passwordValidator('Pa$s$s');