<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Контакты</title>
    <meta name="description" content = "Киномонстр - это портал о кино" />
    <meta name="keywords" content = "фильмы, фильмы онлайн, hd" />
    <link rel="stylesheet" href="../css/style.css"></head>

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
            <p>Для отправки отзыва о портале КиноМонстр Вам необходимо войти в систему</p>

            <div class="button"><a href="signin.jsp">Вход</a></div>
            <div class="button"><a href="signup.jsp">Регистрация</a></div>

            <!--            <div class="signButtons">-->

            <!--                <div class="signUp">-->
            <!--                    <div class="button">-->
            <!--                        <a href="#" id="open_pop_up">Регистрация</a>-->
            <!--                    </div>-->
            <!--                    <div class="pop_up" id="pop_up">-->
            <!--                        <div class="pop_up_container">-->
            <!--                            <div class="pop_up_body" id="pop_up_body">-->
            <!--                                <p>КиноМонстр</p>-->
            <!--                                <form action="">-->
            <!--                                    <input type="text" placeholder="Логин">-->
            <!--                                    <input type="text" placeholder="Электронная почта">-->
            <!--                                    <input type="password" placeholder="Пароль">-->
            <!--                                    <button>Регистрация</button>-->
            <!--                                </form>-->
            <!--                                <div class="pop_up_close" id="pop_up_close">&#10006</div>-->
            <!--                            </div>-->
            <!--                        </div>-->
            <!--                    </div>-->
            <!--                </div>-->

            <!--               <div class="signIn">-->
            <!--                   <div class="button">-->
            <!--                       <a href="#" id="open_pop_in">Вход</a>-->
            <!--                   </div>-->
            <!--                   <div class="pop_up" id="pop_in">-->
            <!--                       <div class="pop_up_container">-->
            <!--                           <div class="pop_up_body" id="pop_in_body">-->
            <!--                               <p>КиноМонстр</p>-->
            <!--                               <form action="">-->
            <!--                                   <input type="text" placeholder="Логин">-->
            <!--                                   <input type="password" placeholder="Пароль">-->
            <!--                                   <button>Вход</button>-->
            <!--                               </form>-->
            <!--                               <div class="pop_up_close" id="pop_in_close">&#10006</div>-->
            <!--                           </div>-->
            <!--                       </div>-->
            <!--                   </div>-->
            <!--               </div>-->

            <!--            </div>-->


        </div>

    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</div>

<script src="/javascript/modalWindow.js"></script>

</body>
</html>
