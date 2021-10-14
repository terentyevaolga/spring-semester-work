<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<form method="post" action="/home" >
    <label for="color">
        <select name="color" id="color">
            <option value="red">Красный</option>
            <option value="yellow">Желтый</option>
            <option value="black">Черный</option>
        </select>
    </label>
    <input type="submit" value="Color send">
</form>

</body>
</html>
