let signin = document.querySelector('.signin-form'),
    signinInputs = document.querySelectorAll('.input-field')


signin.onsubmit = function () {
    let emptyInputs = Array.from(signinInputs).filter(input => input.value === '');

    signinInputs.forEach(function (input) {
        if (input.value === '') {
            input.classList.add('error');
        } else {
            input.classList.remove('error');
        }
    });

    if (emptyInputs.length !== 0) {
        return false;
    }
}