<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

<div class="form-style-5">
    <form class="signin-form" method="post" action="/signin">
        <lable for="name">User name
            <input class="input input-field name" id="name" type="text" name="name">
        </lable>
        <lable for="password">Password
            <input class="input input-field password" id="password" type="password" name="password">
        </lable>
        <input type="submit" value="Sign In" class="btn">
    </form>
</div>


<script src="/javascript/signin.js"></script>
</body>
</html>
