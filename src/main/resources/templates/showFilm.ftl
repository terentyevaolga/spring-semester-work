<html>
<head>
  <link rel="stylesheet" href="../css/style.css">
  <title>${film.name}</title>
</head>
<body>
<div class="main">
    <#include "header.ftl"/>

  <div class="site_content">

      <#include "sidebarContent.ftl"/>

    <div class="content">
      <h1>${film.name}</h1>

      <iframe width="560" height="315" src="${film.trailer}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

      <div class="info_film_page">
        <span class="lable">rating: </span>
        <span class="value">${film.rating}</span>
        <span class="lable">year: </span>
        <span class="value">${film.year}</span>
        <span class="lable">director: </span>
        <span class="value">${film.director}</span>
      </div>

      <hr>

      <h2>Description of film '${film.name}'</h2>
      <div class="description_film">
        <img src="${film.image}">
        ${film.description}
      </div>

      <hr>
      <h2>Review about film</h2>

      <#list reviews as review>
        <div class="reviews">
          <div class="review_name">
            <td>
              ${review.userName}"
            </td>
          </div>
          <div class="review_text">
            <td>
              ${review.text}
            </td>
          </div>
        </div>
      </#list>

      <div class="send">
        <form method="post" action="/show_film" id="review" >

          <input type="text" name="review_name" required="" placeholder="your name">film
          <textarea name="review_text" required=""></textarea>
          <button name="submit"> Send review </button>
        </form>
      </div>

    </div>

  </div>

  <footer>
    <#include "footer.ftl"/>
  </footer>

</div>

</body>
</html>
