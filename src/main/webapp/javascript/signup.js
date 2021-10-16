let form = document.querySelector('.signup-form'),
    formInputs = document.querySelectorAll('.input-field'),
    inputEmail = document.querySelector('.email'),
    inputPassword = document.querySelector('.password')

function validateEmail(email) {
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function validateCountry(country) {
    let re = new RegExp('.co$')
    return re.test(String(country).toLowerCase());
}

form.onsubmit = function () {
    let email = inputEmail.value,
        password = inputPassword.value,
        emptyInputs = Array.from(formInputs).filter(input => input.value === '');

    formInputs.forEach(function (input) {
        if (input.value === '') {
            input.classList.add('error');
        } else {
            input.classList.remove('error');
        }
    });

    if (emptyInputs.length !== 0) {
        return false;
    }

    if (!validateEmail(email)) {
        email.classList.add('error');
        return false;
    } else {
        email.classList.remove('error');
    }

    if (!validateCountry(email)) {
        email.classList.add('error');
        return false;
    } else {
        email.classList.remove('error');
    }
}

