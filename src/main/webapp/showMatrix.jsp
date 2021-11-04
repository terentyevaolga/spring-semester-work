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
                    <li><a href="showInterstellar.html">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="showMatrix.html">Матрица</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="showMax.html">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="showCloud.html">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
                </ul>
            </div>

            <div class="sidebar">
                <h2>Рейтинг сериалов</h2>
                <ul>
                    <li><a href="../show_serials_pages/showBreakingbad.html">Во все тяжкие</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="../show_serials_pages/showDead.html">Ходячие мертвецы</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="../show_serials_pages/showSilicon.html">Кремниевая долина</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="../show_serials_pages/showXfiles.html">Секретные материалы</a><span class="rating_sidebar">7.4</span></li>
                </ul>
            </div>

        </div>

        <div class="content">
            <h1>Матрица: Революция</h1>

            <iframe width="560" height="315" src="https://www.youtube.com/embed/2HWzJ0H4zto" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <div class="info_film_page">
                <span class="lable">рейтинг: </span>
                <span class="value">8.0/10</span>
                <span class="lable">год: </span>
                <span class="value">2003</span>
                <span class="lable">режиссер: </span>
                <span class="value">Лана Вачовски</span>
            </div>

            <hr>

            <h2>Описание Матрица: Революция</h2>
            <div class="description_film">
                <img src="img/films/matrix.png">
                Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он бы не смог проникнуть. Но однажды всё меняется. Томас узнаёт ужасающую правду о реальности.            </div>

            <hr>
            <h2>Отзывы об Матрица: Революция</h2>

            <div class="reviews">
                <div class="review_name">
                    Иван
                </div>

                <div class="review_text">
                    Неплохая идея скатилась до ужасного исполнения. Не рекомендую.
                </div>
            </div>

            <div class="reviews">
                <div class="review_name">
                    Владимир
                </div>

                <div class="review_text">
                    Пересмотрев трилогию братьев(сестёр) Вачовски, совершенно по-новому увидел эти фильмы. Безусловно, фильм «Матрица: Революция» это прекрасное завершение потрясающей серии фильмов.
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
