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
            <jsp:include page="sidebarContent.jsp"/>
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

