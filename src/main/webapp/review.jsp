<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзыв о портале</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>

<div class="form-style-5">
    <h2>Пожалуйста, оставьте ваш отзыв о портале КиноМонстр</h2>
    <form class="sendReview-form" method="post" action="/sendReview">
<%--            <input class="input input-field name" id="name" type="text" name="name" placeholder="Ваше имя">--%>
<%--            <input class="input input-field email" id="email" type="email" name="email" placeholder="Ваш email">--%>
            <input class="input input-field phone" id="phone" type="text" name="phone" placeholder="+7 (___) __ - __ - __">
            <input class="input input-field text" name="comment" placeholder=". . .">
            <input type="submit" value="Отправить отзыв" class="btn">

            <div class="button"><a href="index.jsp">Вернуться на главную</a></div>
    </form>
</div>


<script src="javascript/sendReview.js"></script>
</body>
</html>