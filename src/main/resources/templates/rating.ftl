<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Рейтинг</title>
  <meta name="description" content="Киномонстр - это портал о кино"/>
  <meta name="keywords" content="фильмы, фильмы онлайн, hd"/>
  <link rel="stylesheet" href="../css/style.css">

</head>
<body>
<div class="main">
    <#include "header.ftl"/>

  <div class="site_content">

      <#include page="sidebarContent.ftl"/>

    <div class="content">

      <table>
        <tr>
          <th></th>
          <th>Фильмы</th>
          <th class="center">Год</th>
          <th class="center">Рейтинг</th>
        </tr>

        <tr>
          <td class="center"><img src="img/inter.png"></td>
          <td>1. <a href="#">Интерстеллар</a></td>
          <td class="center">2014</td>
          <td class="center rating">8.1</td>
        </tr>

        <tr>
          <td class="center"><img src="img/matrix.png"></td>
          <td>2. <a href="#">Матрица</a></td>
          <td class="center">1999</td>
          <td class="center rating">8.0</td>
        </tr>

        <tr>
          <td class="center"><img src="img/max.png"></td>
          <td>3. <a href="#">Безумный макс</a></td>
          <td class="center">2015</td>
          <td class="center rating">7.5</td>
        </tr>

        <tr>
          <td class="center"><img src="img/cloud.png"></td>
          <td>4. <a href="#">Облачный атлас</a></td>
          <td class="center">2013</td>
          <td class="center rating">7.4</td>
        </tr>
      </table>

    </div>

  </div>

    <#include "footer.ftl"/>
</div>
</body>
</html>
