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
