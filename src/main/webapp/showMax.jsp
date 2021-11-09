<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Безумный Макс</h1>

            <iframe width="560" height="315" src="https://www.youtube.com/embed/an_MiUmpgs0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <div class="info_film_page">
                <span class="lable">рейтинг: </span>
                <span class="value">7.5/10</span>
                <span class="lable">год: </span>
                <span class="value">2015</span>
                <span class="lable">режиссер: </span>
                <span class="value">Джордж Миллер</span>
            </div>

            <hr>

            <h2>Описание Безумный Макс</h2>
            <div class="description_film">
                <img src="img/cloud.png">
                Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и ученых отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешетсвий человека и переселить человечество на другую планету.
            </div>

            <hr>
            <h2>Отзывы об Облачный атлас</h2>

            <c:forEach var="review" items="${reviews}">
                <div class="reviews">
                    <div class="review_name">
                        <td>
                            <c:out value="${review.userName}"/>
                        </td>
                    </div>
                    <div class="review_text">
                        <td>
                            <c:out value="${review.text}"/>
                        </td>
                    </div>
                </div>
            </c:forEach>

            <div class="send">
                <form method="post" action="/show_film" id="review" >

                    <input type="text" name="review_name" placeholder="ваше имя" required="">film
                    <textarea name="review_text" required=""></textarea>
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

