<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>
<div class="form-style-5">
    <h2>КиноМонстр</h2>

    <%
        String name = "", password = "", remember = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                } else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                } else if (cookie.getName().equals("userRemember")) {
                    remember = cookie.getValue();
                }
            }
        }
    %>

    <form class="signin-form" method="post" action="/signin">
        <input class="input input-field name" type="text" id="name" name="name" placeholder="Логин">
        <input class="input input-field password" type="password" id="password" name="password" placeholder="Введите пароль">
        <input type="submit" value="Войти" class="btn">
    </form>
    <div class="input_wrap">
        <label> Remember me:</label> <input type="checkbox" name="remember" value="1"
        <%="1".equals(remember) ? "checked='/checked'" : "" %> >
    </div>
    <div class="button"><a href="signin.ftl">Перейти к регистрации</a></div>
</div>

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
