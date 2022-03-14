<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Контакты</title>
    <meta name="description" content = "Киномонстр - это портал о кино" />
    <meta name="keywords" content = "фильмы, фильмы онлайн, hd" />
    <link rel="stylesheet" href="../css/style.css"></head>

<body>
<div class="main">
    <header>
        <jsp:include page="header.jsp"/>
    </header>

    <div class="site_content">

        <div class="sidebar_container">
            <jsp:include page="sidebarContent.jsp"/>
        </div>

        <div class="content">
            <h1>Контакты</h1>
            <p>Отправьте ваш отзыв о портале КиноМонстр</p>

            <div class="button"><a href="review.jsp">Отправить отзыв</a></div>

            <div class="feedback">
                <h2>Вы также можете связаться с нами:</h2>
                <a href="tel: 8(800) 550-04-49">&#9742;  8 (800) 550-04-79</a>
                <a href="mailto:kinomonster@kino.ru">&#9997; kinomonster@kino.ru</a>
            </div>


        </div>
    </div>
</div>
</body>
</html>
