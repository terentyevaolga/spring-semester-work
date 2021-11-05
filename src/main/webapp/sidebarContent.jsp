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
            <li><a href="layout/show_films_pages/showInterstellar.html">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
            <li><a href="layout/show_films_pages/showMatrix.html">Матрица</a><span class="rating_sidebar">8.0</span></li>
            <li><a href="layout/show_films_pages/showMax.html">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
            <li><a href="layout/show_films_pages/showCloud.html">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
        </ul>
    </div>

    <div class="sidebar">
        <h2>Рейтинг сериалов</h2>
        <ul>
            <li><a href="layout/show_serials_pages/showBreakingbad.html">Во все тяжкие</a><span class="rating_sidebar">8.1</span></li>
            <li><a href="layout/show_serials_pages/showDead.html">Ходячие мертвецы</a><span class="rating_sidebar">8.0</span></li>
            <li><a href="layout/show_serials_pages/showSilicon.html">Кремниевая долина</a><span class="rating_sidebar">7.5</span></li>
            <li><a href="layout/show_serials_pages/showXfiles.html">Секретные материалы</a><span class="rating_sidebar">7.4</span></li>
        </ul>
    </div>
</div>
</body>
</html>
