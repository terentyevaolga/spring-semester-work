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
            <jsp:include page="sidebarContent.jsp"/>
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
