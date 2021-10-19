<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

<div class="form-style-5">
    <form class="signup-form" method="post" action="/signup">
        <label for="name">Логин
            <input class="input input-field name" type="text" id="name" name="name">
        </label>
        <label for="email">Электронная почта
            <input class="input input-field email" type="email" id="email" name="email">
        </label>
        <label for="password">Пароль
            <input class="input input-field password" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Зарегестрироваться" class="btn">
    </form>
</div>


<script src="/javascript/signup.js"></script>
</body>
</html>
