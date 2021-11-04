<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Сериалы</title>
    <meta name="description" content = "Киномонстр - это портал о кино" />
    <meta name="keywords" content = "фильмы, фильмы онлайн, hd" />
    <link rel="stylesheet" href="../css/style.css">

</head>
<body>
<div class="main">
    <header>
        <jsp:include page="header.jsp"/>
    </header>

    <div class="site_content">

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
                    <li><a href="show_films_pages/showInterstellar.html">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="show_films_pages/showMatrix.html">Матрица</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="show_films_pages/showMax.html">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="show_films_pages/showCloud.html">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
                </ul>
            </div>

            <div class="sidebar">
                <h2>Рейтинг сериалов</h2>
                <ul>
                    <li><a href="show_serials_pages/showBreakingbad.html">Во все тяжкие</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="show_serials_pages/showDead.html">Ходячие мертвецы</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="show_serials_pages/showSilicon.html">Кремниевая долина</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="show_serials_pages/showXfiles.html">Секретные материалы</a><span class="rating_sidebar">7.4</span></li>
                </ul>
            </div>

        </div>

        <div class="content">

            <div class="info_film">
                <img src="assets/img/serials/breakingbad.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
                <div class="button"><a href="show_serials_pages/showBreakingbad.html">Смотреть</a></div>
            </div>

            <div class="info_film">
                <img src="assets/img/serials/dead.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
                <div class="button"><a href="show_serials_pages/showDead.html">Смотреть</a></div>
            </div>

            <div class="info_film">
                <img src="assets/img/serials/silicon.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
                <div class="button"><a href="show_serials_pages/showSilicon.html">Смотреть</a></div>
            </div>

            <div class="info_film">
                <img src="assets/img/serials/xfiles.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
                <div class="button"><a href="show_serials_pages/showXfiles.html">Смотреть</a></div>
            </div>

        </div>

    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</div>

</body>
</html>
