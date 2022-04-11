<html>
<head>
  <title>Фильмы</title>
  <meta name="description" content="Киномонстр - это портал о кино"/>
  <meta name="keywords" content="фильмы, фильмы онлайн, hd"/>
  <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<div class="main">
    <#include "header.ftl"/>

  <div class="site_content">

    <div class="sidebar_container">
        <#include "sidebarContent.ftl"/>
    </div>

    <div class="content">

        <#list films as film>
      <div class="info_film">
        <img src="${film.imageURL}">
        <td>
          "${film.description}"
        </td>
        <form action="/films" method="post">
          <button type="submit" class="button" name="film" value="${film.id}">Смотреть</button>
        </form>
      </div>

  </div>
</div>

<#include "footer.ftl"/>
</body>
</html>
