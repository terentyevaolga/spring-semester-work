<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзыв о портале</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

<div class="form-style-5">
    <form class="sendReview-form" method="post" action="/sendReview">
        <lable for="name">Ваше имя
            <input class="input input-field name" id="name" type="text" name="name">
        </lable>
        <lable for="email">Ваш email
            <input class="input input-field email" id="email" type="email" name="email">
        </lable>
        <lable for="comment">Ваш отзыв
            <textarea class="input input-field text" name="comment"></textarea>
        </lable>
        <input type="submit" value="Отправить отзыв" class="btn">

        <div class="button"><a href="index.html">Вернуться на главную</a></div>
    </form>
</div>


<script src="/javascript/sendReview.js"></script>
</body>
</html>