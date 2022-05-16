<html lang="ru">
<head>
    <title>Main</title>
    <link rel="stylesheet" href="resources/css/form.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/slider.css">
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
            <h1>New films</h1>
            <div class="films_block">
                <button class="slider-prev">&#9668;</button>
                <div class="slider-container">
                    <div class="slider-films">
                        <img src="resources/img/matrix.png" alt="ideas">
                        <img src="resources/img/max.png" alt="plisov">
                        <img src="resources/img/inter.png" alt="theories">
                        <img src="resources/img/cloud.png" alt="stiven">
                    </div>
                </div>
                <button class="slider-next">&#9658;</button>
            </div>

            <input type="search" id="input" class="input search-form"
                   placeholder="&#128269;Go to the movie of interest"/>
            <div class="search">
                <ul class="ul">
                    <li><a href="https://youtu.be/2HWzJ0H4zto" target="_blank">матрица</a></li>
                    <li><a href="https://youtu.be/m2vijtILDuk" target="_blank">интерстеллар</a></li>
                    <li><a href="https://youtu.be/_rZou_PqFoo" target="_blank">облачный атлас</a></li>
                    <li><a href="https://youtu.be/an_MiUmpgs0" target="_blank">безумный Макс</a></li>
                </ul>
            </div>

            <div class="posts">

                <hr>
                <h2><a href="#">How Interstellar was filmed</a></h2>

                <div class="posts_content">
                    <p>
                        Those who worked on Interstellar noted the fanatical enthusiasm of director Christopher Nolan. He did nothing half-heartedly and was able to infect others with his zeal. Jessica Chastain, who played the daughter of the main character-the pilot, for example, recalled that during filming she had a feeling that she just really didn't want to upset Nolan, because she couldn't afford to be naughty or refuse some work.                    </p>
                </div>
                <p><a href="#">read more</a></p>

                <hr>

                <h2><a href="#">Facts about the film "Cloud Atlas"</a></h2>

                <div class="posts_content">
                    <p>
                        The film “Cloud Atlas” was shot mainly in Germany, and became the most expensive film ever shot in this country. Its total budget exceeded 102 million dollars. At the same time, the directors Wachowski and Tykwer shot different episodes at the same time.                    </p>
                </div>
                <p><a href="#">read more</a></p>

            </div>



        </div>


    </div>

    <#--    <div class="form-style-5">-->
    <#--        <h2>Hello, ${user.name}</h2>-->
    <#--    </div>-->

    <footer>
        <#include "footer.ftl"/>
    </footer>
</div>

<script src="resources/javascript/slider.js"></script>
<script src="resources/javascript/searchForm.js"></script>

</body>
</html>