<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Рейтинг</title>
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


        <div class="content">

            <table>
                <tr>
                    <th></th>
                    <th>Фильмы</th>
                    <th class="center">Год</th>
                    <th class="center">Рейтинг</th>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/films/inter.png"></td>
                    <td>1. <a href="show_films_pages/showInterstellar.html">Интерстеллар</a></td>
                    <td class="center">2014</td>
                    <td class="center rating">8.1</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/films/matrix.png"></td>
                    <td>2. <a href="show_films_pages/showMatrix.html">Матрица</a></td>
                    <td class="center">1999</td>
                    <td class="center rating">8.0</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/films/max.png"></td>
                    <td>3. <a href="show_films_pages/showMax.html">Безумный макс</a></td>
                    <td class="center">2015</td>
                    <td class="center rating">7.5</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/films/cloud.png"></td>
                    <td>4. <a href="show_films_pages/showCloud.html">Облачный атлас</a></td>
                    <td class="center">2013</td>
                    <td class="center rating">7.4</td>
                </tr>
            </table>

            <table>
                <tr>
                    <th></th>
                    <th>Сериалы</th>
                    <th class="center">Год</th>
                    <th class="center">Рейтинг</th>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/serials/breakingbad.png"></td>
                    <td>1. <a href="show_serials_pages/showBreakingbad.html">Во все тяжкие</a></td>
                    <td class="center">2019</td>
                    <td class="center rating">7.2</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/serials/dead.png"></td>
                    <td>2. <a href="show_serials_pages/showDead.html">Ходячие мертвецы</a></td>
                    <td class="center">2010</td>
                    <td class="center rating">9.0</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/serials/silicon.png"></td>
                    <td>3. <a href="show_serials_pages/showSilicon.html">Кремниевая долина</a></td>
                    <td class="center">2014</td>
                    <td class="center rating">8.5</td>
                </tr>

                <tr>
                    <td class="center"><img src="assets/img/serials/xfiles.png"></td>
                    <td>4. <a href="show_serials_pages/showXfiles.html">Секретные материалы</a></td>
                    <td class="center">1993</td>
                    <td class="center rating">8.2</td>
                </tr>
            </table>

        </div>

    </div>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</div>


<script src="libs/jquery/jquery.js"></script>
<script src="js/main.js"></script>

</body>
</html>
