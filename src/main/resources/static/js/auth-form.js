const signUpBtn = document.querySelector('#signup-btn');
const passwordInputS= document.querySelectorAll('#password');
const confirmPasswordInputS= document.querySelectorAll('#confirm-password');


for (const elem of confirmPasswordInputS) {
    elem.addEventListener("input", checkPassword);
    elem.addEventListener("focus", checkPassword);
    elem.addEventListener("blur", checkPassword);
}

for (const elem of passwordInputS) {
    elem.addEventListener("input", checkPassword);
    elem.addEventListener("focus", checkPassword);
    elem.addEventListener("blur", checkPassword);
}

function checkPassword(){
    const passwordInput= document.querySelector('#password');
    const confirmPasswordInput= document.querySelector('#confirm-password');
    if (passwordInput.value !== ''){
        if (passwordInput.value !== confirmPasswordInput.value){
            signUpBtn.disabled = true;
            passwordInput.style.background = '#9a1400';
            confirmPasswordInput.style.background = '#9a1400';
        }else {
            signUpBtn.disabled = false;
            passwordInput.style.background = '#138f00';
            confirmPasswordInput.style.background = '#138f00';
        }
    }else {
        signUpBtn.disabled = true;
        passwordInput.style.background = '#333';
        confirmPasswordInput.style.background = '#333';
    }
}
