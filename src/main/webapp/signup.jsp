<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>
<div class="form-style-5">
    <form class="signup-form" method="post" action="/signup">
        <input class="input input-field name" type="text" id="name" name="name" placeholder="Логин">
        <input class="input input-field email" type="email" id="email" name="email" placeholder="Email">
        <input class="input input-field password" type="password" id="password" name="password" placeholder="Введите пароль(от 4 до 8 символов, 1 заглавная буква и цифра)">
        <input type="submit" value="Регистрация" class="btn">
    </form>
</div>

<script>
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

    // /* валидация пароля: от 6 до 20 символов, 1 цифра, 1 большая буква, 1 маленькая буква, только латинский алфавит*/
    // function validatePassword(password) {
    //     let re = /(?=.*\d+.*)(?=.*[A-Z]+.*)\w{4,8}/;
    //     return re.test(String(password).toLowerCase());
    // }

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

        // if (!validatePassword(password)) {
        //     password.classList.add('error');
        //     return false;
        // } else {
        //     password.classList.remove('error');
        // }

        if (!validateCountry(email)) {
            email.classList.add('error');
            return false;
        } else {
            email.classList.remove('error');
        }
    }

</script>
</body>
</html>
