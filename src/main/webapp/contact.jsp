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
                    <li><a href="show_films_pages/showInterstellar.html">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="show_films_pages/showMatrix.html">Матрица</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="show_films_pages/showMax.html">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="show_films_pages/showCloud.html">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
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

        <!--Форма для отправки отзывов от портале Киномонстр-->
        <div class="content">
            <h1>Контакты</h1>
            <p>Отправьте ваш отзыв о портале КиноМонстр</p>

            <div class="button"><a href="reviewRequest.jsp">Отправить отзыв</a></div>

            <!--		<div class="send send_contact">-->
            <!--				<form method="post" action="#" id="contact">-->
            <!--					<input type="text" name="review_name" placeholder="ваше имя">-->
            <!--					<input type="text" name="review_email" placeholder="ваш email">-->
            <!--					<textarea name="review_text"></textarea>-->
            <!--					<input type="submit" value="отправить">-->

            <!--				</form>-->
            <!--			</div>-->

        </div>
    </main>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

<script src="/javascript/modalWindow.js"></script>

</body>
</html>
