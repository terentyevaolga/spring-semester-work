<html lang="ru">
<head>
    <title>SignIn</title>
    <link rel="stylesheet" href="resources/css/form.css">
</head>
<body>
<div class="form-style-5">
    <h2>KinoMonster</h2>

    <form class="signin-form" method="post" action="/signIn">
        <label for="name"><input class="input input-field name" type="text" id="name" name="name" placeholder="Login"></label>
        <label for="password"><input class="input input-field password" type="password" id="password" name="password" placeholder="Enter password"></label>
        <input type="submit" value="SignIn" class="btn">
    </form>
    <div class="input_wrap">
        <label> Remember me:</label>
        <input type="checkbox" name="remember" value="1"/>
    </div>
    <div class="button"><a href="signup">Go to registration</a></div>
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
