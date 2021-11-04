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
            <h1>Интерстеллар</h1>

            <iframe width="560" height="315" src="https://www.youtube.com/embed/DfDXxwck9gs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <div class="info_film_page">
                <span class="lable">рейтинг: </span>
                <span class="value">8.1/10</span>
                <span class="lable">год: </span>
                <span class="value">2014</span>
                <span class="lable">режиссер: </span>
                <span class="value">Кристофер Нолан</span>
            </div>

            <hr>

            <h2>Описание Интерстеллар</h2>
            <div class="description_film">
                <img src="img/films/inter.png">
                Наше время на Земле подошло к концу, команда исследователей берет на себя самую важную миссию в истории человечества; путешествуя за пределами нашей галактики, чтобы узнать есть ли у человечества будущее среди звезд.
            </div>

            <hr>
            <h2>Отзывы об Интерстеллар</h2>

            <div class="reviews">
                <div class="review_name">
                    Сергей
                </div>

                <div class="review_text">
                    Отличный фильм, 3 часа пролетели незаметно.
                </div>
            </div>

            <div class="reviews">
                <div class="review_name">
                    Дмитрий
                </div>

                <div class="review_text">
                    После фильма Начало, я с нетерпением ждал еще работ от Кристофера Нолана. Интерстеллар меня впечатлил.
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
