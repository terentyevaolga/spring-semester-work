<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>
<div class="form-style-5">
    <h2>КиноМонстр</h2>
    <form class="signup-form" method="post" action="/signup">
        <input class="input input-field name" type="text" id="name" name="name" placeholder="Логин">
        <input class="input input-field email" type="email" id="email" name="email" placeholder="Email">
        <lable><p>Длина пароля от 4 до 12 символов, обязательны одна заглавная буква и цифра</p>
            <input class="input input-field password" type="password" id="password" name="password" placeholder="Введите пароль">
        </lable>
        <input type="submit" value="Регистрация" class="btn">
    </form>
    <div class="button"><a href="signin.ftl">Войти</a></div>
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

    form.onsubmit = function () {
        let email = inputEmail.value,
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

</script>
</body>
</html>
