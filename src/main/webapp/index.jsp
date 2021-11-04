<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/slider.css">
    <title>Главная</title>
</head>
<body>
<div class="main">
    <header>
        <jsp:include page="header.jsp"/>
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

        <!-- делаем слайдер  -->
        <div class="content">
            <h1>Новые фильмы</h1>
            <div class="films_block">
                <button class="slider-prev">&#9668;</button>
                <div class="slider-container">
                    <div class="slider-films">
                        <img src="img/films/matrix.png" alt="ideas">
                        <img src="img/films/max.png" alt="plisov">
                        <img src="img/films/inter.png" alt="theories">
                        <img src="img/films/cloud.png" alt="stiven">
                        <img src="img/serials/dead.png" alt="cat">
                    </div>
                </div>
                <button class="slider-next">&#9658;</button>
            </div>

            <h1>Новые сериалы</h1>
            <div class="films_block">
                <button class="slider-back">&#9668;</button>
                <div class="slider-container">
                    <div class="slider-serials">
                        <img src="img/serials/dead.png" alt="ideas">
                        <img src="img/serials/silicon.png" alt="plisov">
                        <img src="img/serials/breakingbad.png" alt="theories">
                        <img src="img/serials/xfiles.png" alt="stiven">
                        <img src="img/films/cloud.png" alt="cat">
                    </div>
                </div>
                <button class="slider-forward">&#9658;</button>
            </div>

            <div class="posts">

                <hr>
                <h2><a href="#">Как снимали Интерстеллар</a></h2>

                <!-- тут добавляю статью из бд -->

                <div class="posts_content">
                    <p>
                        Работавшие над «Интерстелларом» отмечали фанатичный энтузиазм режиссер Кристофер Нолана. Он ничего не делал вполсилы и умел заразить своим рвением других. Джессика Честейн, сыгравшая дочку главного героя-летчика, например, вспоминала, что во время съемок у нее было чувство, что просто очень не хочется расстраивать Нолана, потому она не могла позволить себе капризничать или отказываться от какой-то работы.
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

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

<script src="javascript/slider.js"></script>
</body>
</html>
