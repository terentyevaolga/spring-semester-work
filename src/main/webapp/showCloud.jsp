<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Описание фильма</title>
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
                    <li><a href="#">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="#">Матрица</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="#">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="#">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
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
            <h1>Облачный атлас</h1>

            <iframe width="560" height="315" src="https://www.youtube.com/embed/_rZou_PqFoo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <div class="info_film_page">
                <span class="lable">рейтинг: </span>
                <span class="value">7.4/10</span>
                <span class="lable">год: </span>
                <span class="value">2012</span>
                <span class="lable">режиссер: </span>
                <span class="value">Том Тыквер</span>
            </div>

            <hr>

            <h2>Описание Облачный атлас</h2>
            <div class="description_film">
                <img src="img/films/cloud.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
            </div>

            <hr>
            <h2>Отзывы об Облачный атлас</h2>

            <div class="reviews">
                <div class="review_name">
                    Маргарита
                </div>

                <div class="review_text">
                    Забавно видеть перетащенного из Матрицы агента Смита. Есть несколько шуток и смешных ситуаций, спецэффекты, интересная, но излишне мультяшная на мой вкус картинка. На этом всё.

                </div>
            </div>

            <div class="reviews">
                <div class="review_name">
                    Андрей
                </div>

                <div class="review_text">
                    Фильм - редкостная, дешёвая, но великолепно снятая дрянь, пересматривать которую (мне - россиянину) совсем не хочется.
                </div>
            </div>

            <div class="send">
                <form method="post" action="#" id="review" >

                    <input type="text" name="review_name" placeholder="ваше имя">
                    <textarea name="review_text"></textarea>
                    <input type="submit" value="отправить">

                </form>

            </div>

        </div>

    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

</body>
</html>
