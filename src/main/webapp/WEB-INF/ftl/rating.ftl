<html lang="ru">
<head>
  <title>Рейтинг фильмов</title>
  <link rel="stylesheet" href="resources/css/form.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <link rel="stylesheet" href="resources/css/header.css">
</head>

<body>
<div class="main">

  <header>
    <#include "header.ftl"/>
  </header>

  <div class="site_content">

    <div class="sidebar_container">
      <#include "sidebarContent.ftl"/>
    </div>

    <div class="content">

      <table>
        <tr>
          <th></th>
          <th>Films</th>
          <th class="center">Year</th>
          <th class="center">Rating</th>
        </tr>

        <tr>
          <td class="center"><img src="resources/img/inter.png"></td>
          <td>1. <a href="#">Interstellar</a></td>
          <td class="center">2014</td>
          <td class="center rating">8.1</td>
        </tr>

        <tr>
          <td class="center"><img src="resources/img/matrix.png"></td>
          <td>2. <a href="#">Matrix</a></td>
          <td class="center">1999</td>
          <td class="center rating">8.0</td>
        </tr>

        <tr>
          <td class="center"><img src="resources/img/max.png"></td>
          <td>3. <a href="#">Mad Max</a></td>
          <td class="center">2015</td>
          <td class="center rating">7.5</td>
        </tr>

        <tr>
          <td class="center"><img src="resources/img/cloud.png"></td>
          <td>4. <a href="#">Cloud Atlas</a></td>
          <td class="center">2013</td>
          <td class="center rating">7.4</td>
        </tr>
      </table>
    </div>

  </div>
  <footer>
    <#include "footer.ftl"/>
  </footer>
</div>
</body>
</html>
