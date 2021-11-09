<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Фильмы</title>
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
        <jsp:include page="sidebarContent.jsp"/>
    </div>

        <div class="content">

            <c:forEach var="film" items="${films}">
                <div class="info_film">
                    <img src="${film.imageURL}">
                    <td>
                        <c:out value="${film.description}"/>
                    </td>
                    <form action="/films" method="post">
                        <button type="submit" class="button" name="film" value="${film.id}">Смотреть</button>
                    </form>
                </div>
            </c:forEach>

        </div>
    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

</body>
</html>
