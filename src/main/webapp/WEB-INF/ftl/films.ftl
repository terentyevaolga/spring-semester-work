<html lang="ru">
<head>
  <title>Фильмы</title>
  <link rel="stylesheet" href="resources/css/form.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <link rel="stylesheet" href="resources/css/header.css">
</head>

<body>
<div class="main">

  <header>
    <#include "header.ftl"/>
  </header>

  <section class="site_content">

    <div class="sidebar_container">
      <#include "sidebarContent.ftl"/>
    </div>

    <section class="content">
      <#list films as film>
        <div class="info_film">
          <img src="${film.image}">
          <td>
            <b>${film.name}</b>
          </td>
          <td>
            <hr>
            ${film.description}
          </td>
          <form action="/films" method="post">
            <button type="submit" class="button" id="film" name="film" value="${film.name}">Watch</button>
          </form>
        </div>
      </#list>
    </section>
  </section>
  <footer>
    <#include "footer.ftl"/>
  </footer>
</div>
</body>
</html>
