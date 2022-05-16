<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" id="name" name="name" placeholder="Введите имя"/>
        <input type="text" id="trailer" name="trailer" placeholder="Ссылка на трейлер"/>
        <input type="text" id="rating" name="rating" placeholder="Рейтинг фильма"/>
        <input type="text" id="year" name="year" placeholder="год выпуска"/>
        <input type="text" id="" name="director" placeholder="Режисер"/>
        <input type="text" name="description" placeholder="описание">
        <input type="file" name="icon">
<#--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        <input type="submit">
    </form>
</div>
</body>
</html>