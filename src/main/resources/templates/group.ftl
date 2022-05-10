<html>
<head>
  <link rel="stylesheet" href="../css/style.css">
  <title>${group.name}</title>
</head>
<body>
<div class="main">
    <#include "header.ftl"/>

  <div class="site_content">

      <#include "sidebarContent.ftl"/>

    <div class="content">
      <h1>${group.name}</h1>

      <div class="info_film_page">
        <span class="lable">Group description </span>
        <span class="value">${group.description}</span>
        <a href="chat/${group.name}">Group chat</a>
      </div>
      <hr>
      <#list group.users as user>
        <span class="lable"> User name </span>
        <span class="value"> ${user.name} </span>
      </#list>
    </div>

  </div>
  <footer>
      <#include "footer.ftl"/>
  </footer>

</div>
</body>
</html>