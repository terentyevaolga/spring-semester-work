<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>SignUp</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-5">
    <form method="post" action="/signup">
        <label for="name">User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="email">Email
            <input class="input-field" type="text" id="email" name="email">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>
