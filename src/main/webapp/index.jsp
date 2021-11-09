<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/slider.css">
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

        <!-- делаем слайдер  -->
        <div class="content">
                <h1>Новые фильмы</h1>
                <div class="films_block">
                    <button class="slider-prev">&#9668;</button>
                    <div class="slider-container">
                        <div class="slider-films">
                            <img src="img/matrix.png" alt="ideas">
                            <img src="img/max.png" alt="plisov">
                            <img src="img/inter.png" alt="theories">
                            <img src="img/cloud.png" alt="stiven">
                        </div>
                    </div>
                    <button class="slider-next">&#9658;</button>
                </div>

            <input type="search" id="input" class="input search-form" placeholder="&#128269;Перейти к просмотру интересующего фильма" />
            <div class="search">
                <ul class="ul">
                    <li><a href="https://youtu.be/2HWzJ0H4zto" target="_blank">матрица</a></li>
                    <li><a href="https://youtu.be/m2vijtILDuk" target="_blank">интерстеллар</a></li>
                    <li><a href="https://youtu.be/_rZou_PqFoo" target="_blank">облачный атлас</a></li>
                    <li><a href="https://youtu.be/an_MiUmpgs0" target="_blank">безумный Макс</a></li>
                </ul>
            </div>


            <div class="posts">

                <c:forEach var="article" items="${articles}">
                    <div class="posts_content">
                        <h2>
                            <c:out value="${article.title}"/>
                        </h2>
                        <p>
                            <c:out value="${article.description}"/>
                        </p>
                    </div>
                </c:forEach>



<%--                <hr>--%>
<%--                <h2><a href="#">Как снимали Интерстеллар</a></h2>--%>

<%--                <!-- тут добавляю статью из бд -->--%>

<%--                <div class="posts_content">--%>
<%--                    <p>--%>
<%--                        Работавшие над «Интерстелларом» отмечали фанатичный энтузиазм режиссер Кристофер Нолана. Он ничего не делал вполсилы и умел заразить своим рвением других. Джессика Честейн, сыгравшая дочку главного героя-летчика, например, вспоминала, что во время съемок у нее было чувство, что просто очень не хочется расстраивать Нолана, потому она не могла позволить себе капризничать или отказываться от какой-то работы.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <p><a href="#">читать</a></p>--%>

<%--                <hr>--%>

<%--                <h2><a href="#">Факты о фильме "Облачный атлас"</a></h2>--%>

<%--                <div class="posts_content">--%>
<%--                    <p>--%>
<%--                        Снимался фильм “Облачный атлас” в основном в Германии, и стал самым дорогостоящей кинолентой, когда-либо снятым в этой стране. Общий его бюджет превысил 102 миллиона долларов. При этом режиссёры Вачовски и Тыквер снимали разные эпизоды в одно и то же время.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <p><a href="#">читать</a></p>--%>

            </div>

        </div>
    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

<script src="javascript/slider.js"></script>
<script src="javascript/searchForm.js"></script>
</body>
</html>




