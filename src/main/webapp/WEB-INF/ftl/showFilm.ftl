<html>
<head>
    <title>${film.name}</title>
    <link rel="stylesheet" href="/resources/css/form.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/animate.css">
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

        <div class="content">
            <h1>${film.name}</h1>

            <#--      <iframe width="560" height="315" src="${film.trailer}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->

            <iframe width="642" height="361" src="https://www.youtube.com/embed/nNpvWBuTfrc"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>

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
                ${film.description}
            </div>

            <hr>
            <h2>Review about film</h2>

            <#list reviews as review>
                <div class="reviews">
                    <div class="review_name">
                        <td>
                            ${review.userName}
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
                <form method="post" action="/show_film/${film.name}" id="review">
                    <input type="text" id="review_name" name="review_name" required="" placeholder="Enter your name">
                    <hr>
                    <textarea id="review_text" name="review_text" required="" placeholder="&nbsp;Enter your review"></textarea>
                    <input type="submit" value="Send">
                </form>
            </div>

        </div>
    </section>

    <footer>
        <#include "footer.ftl"/>
    </footer>

</div>
</body>
</html>
