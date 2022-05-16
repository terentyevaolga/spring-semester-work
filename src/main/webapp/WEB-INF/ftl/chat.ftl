<!DOCTYPE html>
<html>
<head>
  <title>Hello WebSocket</title>
  <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/sockjs-client/sockjs.min.js"></script>
  <script src="/webjars/stomp-websocket/stomp.min.js"></script>
</head>
<body>
<script type="application/javascript">
  let stompClient = null;

  function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $('#disconnect').prop("disabled", !connected);
    if (connected) {
      $("#conversation").show();
    }
    else {
      $("#conversation").hide();
    }
    $("#greetings").html("");
  }

  function connect() {
    let socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
      setConnected(true);
      console.log('Connected: ' + frame);
      stompClient.subscribe('/chat/${group.name}/messages', function (greeting) {
        showGreeting(JSON.parse(greeting.body));
      });
    });
  }

  function disconnect() {
    if (stompClient !== null) {
      stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
  }

  function sendMessage () {
    let msg = $("#message").val();
    if (msg.trim() !== "") {
      const message = {
        text: msg,
        from: ${userName}
        group: ${group.name}
      };
      stompClient.send("/app/chat/${group.name}", {}, JSON.stringify(message));
    }
  }

  function showGreeting(message) {
    $("#greetings").append("<tr>" +
        "<td>" + message.time + "</td>" +
        "<td>" + message.from + "</td>" +
        "<td>" + message.text + "</td>" +
        "</tr>");
  }

  $(function () {
    $("form").on('submit', function (e) {
      e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $.ajax({
      url: '/chat/last/${group.name}',         /* Куда пойдет запрос */
      method: 'get',             /* Метод передачи (post или get) */
      dataType: 'json',          /* Тип данных в ответе (xml, json, script, html). */
      success: function (data) { /* функция которая будет выполнена после успешного запроса.  */
        data.forEach(element => {
          showGreeting(element);
        })
        alert(data);
      }
    });
    $( "#send" ).click(function() { sendMessage(); });
  });
</script>
<div id="main-content" class="container">
  <div class="row">
    <div class="col-md-6">
      <form class="form-inline">
        <div class="form-group">
          <label for="connect">WebSocket connection:</label>
          <button id="connect" class="btn btn-default" type="submit">Connect</button>
          <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
          </button>
        </div>
      </form>
    </div>
    <div class="col-md-6">
      <form class="form-inline">
        <div class="form-group">
          <label for="name">Start chatting! </label>
          <input type="text" id="message" class="form-control" placeholder="Message">
        </div>
        <button id="send" class="btn btn-default" type="submit">Send</button>
      </form>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <table id="conversation" class="table table-striped">
        <thead>
        <tr>
          <th>Greetings</th>
        </tr>
        </thead>
        <tbody id="greetings">
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>