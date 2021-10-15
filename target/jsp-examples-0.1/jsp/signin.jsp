<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-5">
    <form method="post" action="/signin">
        <lable for="name">User name<input id="name" type="text" name="name"></lable><br>
        <lable for="password">Password<input id="password" type="password" name="password"></lable><br>
        <input type="submit" value="Sign In">
    </form>
</div>
</body>
</html>
