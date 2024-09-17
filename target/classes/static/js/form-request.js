const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");
const requestBtn = document.querySelector('#request-btn');
const numberOfChildrenInputS = document.querySelectorAll('#number-of-children');

for (const elem of numberOfChildrenInputS) {
    elem.addEventListener("input", changeAgeInput);
    elem.addEventListener("focus", changeAgeInput);
    elem.addEventListener("blur", changeAgeInput);
}

function changeAgeInput(){
    const ageOfChildrenInput = document.querySelector('#age-of-children');
    const ageOfChildrenInputBox = document.querySelector('#age-of-children-box');
    const numberOfChildrenInput = document.querySelector('#number-of-children');
    if (numberOfChildrenInput.value === '0' || numberOfChildrenInput.value === ''){
        ageOfChildrenInput.value = 'Без детей';
        ageOfChildrenInputBox.style.display = 'none';
    }else {
        ageOfChildrenInput.value = '';
        ageOfChildrenInputBox.style.display = 'block';
    }
}

requestBtn.addEventListener('click', ()=>{

    const preferences = document.querySelector('#preferences');
    const numberOfAdults = document.querySelector('#number-of-adults');
    const numberOfChildren = document.querySelector('#number-of-children');
    const ageOfChildren = document.querySelector('#age-of-children');
    const numberOfNights = document.querySelector('#number-of-nights');
    const startDate = document.querySelector('#start-date');
    const budget = document.querySelector('#budget')

    if (
        preferences.value &&
        numberOfAdults.value &&
        numberOfChildren.value &&
        numberOfNights.value &&
        startDate.value &&
        budget.value
    ) {
        const requestData = {
            preferences: preferences.value,
            budget: budget.value,
            numberOfAdults: numberOfAdults.value,
            numberOfChildren: numberOfChildren.value,
            ageOfChildren: ageOfChildren.value,
            numberOfNights: numberOfNights.value,
            startDate: startDate.value
        };

        fetch('/grand_tour/form/sendRequest', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': token
            },
            body: JSON.stringify(requestData),
        })
            .then((response) => {
                console.log(response);
                alert('Заявка успешно отправлена!')
            })
            .catch((error) => {
                console.error('Ошибка при отправке формы:', error);
            });
    } else {
        alert('Заполните все поля, пожалуйста');
    }

})

