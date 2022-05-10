<div class="sidebar_container">

  <script type="application/javascript">
    let page = 1;

    function nextPage() {
      page++;
      getPage(page);
    }

    function previousPage() {
      page--;
      getPage(page);
    }

    function getPage(cur_page) {
      $.ajax({
        url: '/films/rating/' + cur_page,         /* Куда пойдет запрос */
        method: 'get',             /* Метод передачи (post или get) */
        dataType: 'json',          /* Тип данных в ответе (xml, json, script, html). */
        success: function (data) { /* функция которая будет выполнена после успешного запроса.  */
          data.forEach(element => {
            let href = '/show_film/' + element.name;
            $('.film_rating').append('<li>' + element.name)
                .append('<span class="rating_sidebar">' + element.rating + '</span></li>')
                .append('<a href="/films' + href + '"> Watch </a>');
          })
          alert(data);
        }
      });
    }
  </script>

  <div class="sidebar">
    <h2>Films rating</h2>
    <ul class="film_rating" onload="getPage(1)">
    </ul>
    <button onclick="previousPage()"> Previous page</button>
    <button onclick="nextPage()"> Next page</button>
  </div>

</div>
