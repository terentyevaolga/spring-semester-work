<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css"/>
    <title>SidebarContent</title>
</head>
<body>
<div class="sidebar_container">

    <div class="sidebar">
        <h2>Поиск</h2>
        <form method="post" action="#" id="search_form">
            <input type="search" name="search_field" placeholder="ваш запрос" />
            <input type="submit" class="btn" value="найти" />
        </form>
    </div>

    <div class="sidebar">
        <h2>Новости</h2>
        <span>31.03.2017</span>
        <p>Мы запустили расширенный поиск</p>
        <a href="#">читать</a>
    </div>


    <div class="sidebar">
        <h2>Рейтинг фильмов</h2>
        <ul>
            <li><a href="#">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
            <li><a href="#">Матрица</a><span class="rating_sidebar">8.0</span></li>
            <li><a href="#">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
            <li><a href="#">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
        </ul>
    </div>

</div>
</body>
</html>
