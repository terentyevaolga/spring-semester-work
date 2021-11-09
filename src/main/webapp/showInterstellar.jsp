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
                <img src="img/inter.png">
                Наше время на Земле подошло к концу, команда исследователей берет на себя самую важную миссию в истории человечества; путешествуя за пределами нашей галактики, чтобы узнать есть ли у человечества будущее среди звезд.
            </div>
            <hr>
            <h2>Отзывы об Интерстеллар</h2>

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

                    <input type="text" name="review_name" placeholder="ваше имя" required="">
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
