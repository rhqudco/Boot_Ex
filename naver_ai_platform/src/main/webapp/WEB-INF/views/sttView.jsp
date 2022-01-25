<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>STT Form</title>
  </head>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="js/stt.js"></script>
  <body>
      <!--  파일 업로드 -->
      <h3>음석 인식</h3>
      <form id="sttForm" enctype="multipart/form-data">
          파일 : <input type="file" id="uploadFile" name="uploadFile">
          <input type="submit" value="결과 확인">
      </form>
      <br><br>
      <!-- 객체와 좌표 값 출력 -->
      STT 결과 : <div id="resultDiv"></div>
      <br><br>
      <div><audio preload="auto" controls></audio></div>
      <a href="/">index 페이지로 이동</a>
  </body>
</html>
