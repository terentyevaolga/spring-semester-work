<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>
<div class="form-style-5">
    <h2>КиноМонстр</h2>
    <form class="signin-form" method="post" action="/signin">
        <input class="input input-field name" type="text" id="name" name="name" placeholder="Логин">
        <input class="input input-field password" type="password" id="password" name="password" placeholder="Введите пароль">
        <input type="submit" value="Войти" class="btn">
    </form>
    <div class="button"><a href="/index">Вернуться на главную</a></div>
</div>
<%--<h3>${signInStatus}</h3>--%>

<script>
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
</script>

</body>
</html>
