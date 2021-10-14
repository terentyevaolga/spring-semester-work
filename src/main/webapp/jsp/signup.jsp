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

<div class="form-style-5">
    <div class="form-style-5-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>