<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SignUp</title>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

<div class="form-style-5">
    <form class="signup-form" method="post" action="/signup">
        <label for="name">User name
            <input class="input input-field name" type="text" id="name" name="name">
        </label>
        <label for="email">Email
            <input class="input input-field email" type="email" id="email" name="email">
        </label>
        <label for="password">Password
            <input class="input input-field password" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign Up" class="btn">
    </form>
</div>


<script src="/javascript/signup.js"></script>
</body>
</html>
