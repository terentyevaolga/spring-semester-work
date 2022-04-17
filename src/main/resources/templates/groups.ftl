<html>
<head>
  <title>Groups</title>
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

        <#list groups as group>
          <div class="info_film">
            <td>
              "${group.name}"
              ${group.description}
            </td>
            <a href="/groups/${group.name}">See a page</a>
          </div>
        </#list>
    </div>
  </div>
</div>

<#include "footer.ftl"/>
</body>
</html>