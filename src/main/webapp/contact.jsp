<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Контакты</title>
    <meta name="description" content = "Киномонстр - это портал о кино" />
    <meta name="keywords" content = "фильмы, фильмы онлайн, hd" />
    <link rel="stylesheet" href="../css/style.css"></head>

<body>
<div class="main">
    <header>
        <jsp:include page="header.jsp"/>
    </header>

    <main class="site_content">

        <div class="sidebar_container">
            <jsp:include page="sidebarContent.jsp"/>
        </div>

        <!--Форма для отправки отзывов от портале Киномонстр-->
        <div class="content">
            <h1>Контакты</h1>
            <p>Отправьте ваш отзыв о портале КиноМонстр</p>

<%--            <div class="send send_contact">--%>
<%--            <form method="post" action="/sendReview" id="contact">--%>
<%--            <input type="text" name="review_name" placeholder="ваше имя">--%>
<%--            <input type="text" name="review_email" placeholder="ваш email">--%>
<%--            <textarea name="review_text"></textarea>--%>
<%--            <input type="submit" value="отправить">--%>
<%--            </form>--%>
<%--            </div>--%>
            <div class="button"><a href="reviewRequest.jsp">Отправить отзыв</a></div>

        </div>
    </main>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

<%--<script src="/javascript/modalWindow.js"></script>--%>

</body>
</html>
