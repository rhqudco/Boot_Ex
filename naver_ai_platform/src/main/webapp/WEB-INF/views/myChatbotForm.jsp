<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>chatbotForm</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="js/myChatbotForm.js"></script>
    <link rel="stylesheet" type="text/css" href="css/chatbot.css">
  </head>
  <body>
    <div id="wrap">
      <!-- Header -->
      <div id="chatHeader">
        <span>챗봇</span>
        <button id="btnClose">X</button>
      </div>
    <h3>챗봇 서비스</h3>

    <!-- 응답 메시지 출력  -->
    <div id="chatBox"></div><br>

      <div>
        <!-- 질문 메시지 입력 폼 -->
        <form id="chatForm">
          <input type="text" id="message" name="message" size="30" placeholder="질문을 입력하세요">
          <input type="submit" value="전송">
        </form>
      </div><br>

      <div>
      <!-- 음성 녹음 -->
      음성 메세지 : <button id="record">녹음</button>
                    <button id="stop">정지</button>
                    <div id="sound-clips"></div><br>
      </div>
      <div hidden>
        <audio preload="auto" controls></audio>
      </div>
    <br><br>
    <a href="/">index 페이지로 이동</a>
    </div>
  </body>
</html>