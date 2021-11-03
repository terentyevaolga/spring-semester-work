<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="main">
    <header class="header">
        <div class="logo-signButton-flex">
            <div class="logo">
                <div class="logo_text">
                    <h1><a href = "/">КиноМонстр</a></h1>
                    <h2>Кино - наша страсть!</h2>
                </div>
            </div>
        </div>

        <div class="menubar">
            <ul class="menu">
                <li class="selected"><a href = "index.jsp">Главная</a></li>
                <li><a href = "films.jsp">Фильмы</a></li>
                <li><a href = "serials.jsp">Сериалы</a></li>
                <li><a href = "rating.jsp">Рейтинг фильмов/сериалов</a></li>
                <li><a href = "contact.jsp">Контакты</a></li>
            </ul>

        </div>
    </header>

    <main class="site_content">

        <div class="sidebar_container">

            <div class="sidebar">
                <h2>Поиск</h2>
                <form method="post" action="/layout/show_films_pages.html" id="search_form">
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

        <div class="content">
            <h1>Новые фильмы</h1>
            <div class="films_block">
                <a href="#"><img src="layout/assets/img/films/matrix.png"></a>
                <a href="#"><img src="layout/assets/img/films/max.png"></a>
                <a href="#"><img src="layout/assets/img/films/inter.png"></a>
                <a href="#"><img src="layout/assets/img/films/cloud.png"></a>

            </div>

            <h1>Новые сериалы</h1>
            <div class="films_block">
                <a href="#"><img src="layout/assets/img/serials/dead.png"></a>
                <a href="#"><img src="layout/assets/img/serials/silicon.png"></a>
                <a href="#"><img src="layout/assets/img/serials/breakingbad.png"></a>
                <a href="#"><img src="layout/assets/img/serials/xfiles.png"></a>

            </div>

            <div class="posts">

                <hr>
                <h2><a href="#">Как снимали Интерстеллар</a></h2>

                <!-- тут добавляю статью из бд -->

                <div class="posts_content">
                    <p>
                        <%--                        Работавшие над «Интерстелларом» отмечали фанатичный энтузиазм режиссер Кристофер Нолана. Он ничего не делал вполсилы и умел заразить своим рвением других. Джессика Честейн, сыгравшая дочку главного героя-летчика, например, вспоминала, что во время съемок у нее было чувство, что просто очень не хочется расстраивать Нолана, потому она не могла позволить себе капризничать или отказываться от какой-то работы.--%>
                    </p>
                </div>
                <p><a href="/layout/interstellarText.html">читать</a></p>

                <hr>

                <h2><a href="#">Факты о фильме "Облачный атлас"</a></h2>

                <div class="posts_content">
                    <p>
                        Снимался фильм “Облачный атлас” в основном в Германии, и стал самым дорогостоящей кинолентой, когда-либо снятым в этой стране. Общий его бюджет превысил 102 миллиона долларов. При этом режиссёры Вачовски и Тыквер снимали разные эпизоды в одно и то же время.
                    </p>
                </div>
                <p><a href="/layout/cloudText.html">читать</a></p>

            </div>

        </div>
    </main>

    <footer class="footer">
        <p>
            <a href="index.html">Главная</a> |
            <a href="layout/films.html">Фильмы</a> |
            <a href="layout/serials.html">Сериалы</a> |
            <a href="layout/rating.html">Рейтинг фильмов</a> |
            <a href="layout/contact.html">Контакты</a>
        </p>
        <p>wh-db.com 2015</p>
    </footer>

</div>


<script src="layout/libs/jquery/jquery.js"></script>
<script src="layout/js/main.js"></script>

</body>
</html>