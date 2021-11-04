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
                    <li><a href="#">Интерстеллар</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="#">Матрица</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="#">Безумный макс</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="#">Облачный атлас</a><span class="rating_sidebar">7.4</span></li>
                </ul>
            </div>

            <div class="sidebar">
                <h2>Рейтинг сериалов</h2>
                <ul>
                    <li><a href="#">Во все тяжкие</a><span class="rating_sidebar">8.1</span></li>
                    <li><a href="#">Ходячие мертвецы</a><span class="rating_sidebar">8.0</span></li>
                    <li><a href="#">Кремниевая долина</a><span class="rating_sidebar">7.5</span></li>
                    <li><a href="#">Секретные материалы</a><span class="rating_sidebar">7.4</span></li>
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
                    <td class="center"><img src="img/films/inter.png"></td>
                    <td>1. <a href="#">Интерстеллар</a></td>
                    <td class="center">2014</td>
                    <td class="center rating">8.1</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/films/matrix.png"></td>
                    <td>2. <a href="#">Матрица</a></td>
                    <td class="center">1999</td>
                    <td class="center rating">8.0</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/films/max.png"></td>
                    <td>3. <a href="#">Безумный макс</a></td>
                    <td class="center">2015</td>
                    <td class="center rating">7.5</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/films/cloud.png"></td>
                    <td>4. <a href="#">Облачный атлас</a></td>
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
                    <td class="center"><img src="img/serials/breakingbad.png"></td>
                    <td>1. <a href="#">Во все тяжкие</a></td>
                    <td class="center">2019</td>
                    <td class="center rating">7.2</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/serials/dead.png"></td>
                    <td>2. <a href="#">Ходячие мертвецы</a></td>
                    <td class="center">2010</td>
                    <td class="center rating">9.0</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/serials/silicon.png"></td>
                    <td>3. <a href="#">Кремниевая долина</a></td>
                    <td class="center">2014</td>
                    <td class="center rating">8.5</td>
                </tr>

                <tr>
                    <td class="center"><img src="img/serials/xfiles.png"></td>
                    <td>4. <a href="#">Секретные материалы</a></td>
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

</body>
</html>
