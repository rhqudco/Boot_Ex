<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>STT Service2</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="js/tts.js"></script>
  </head>
  <body>
    <!--  파일 업로드 -->
    <h3>음석 인식</h3>
    <form id="ttsForm" enctype="multipart/form-data">
      파일 : <input type="file" id="uploadFile" name="uploadFile">
      <br>
      <br>
      언어 선택 :
      <select name="country" id="country">
        <option value="nara" selected>한국어, 여성</option>
        <option value="jinho">한국어, 남성</option>
        <option value="nhajun">한국어, 아동(남)</option>
        <option value="ndain">한국어, 아동(여)</option>
        <option value="shinji">일본어, 남성</option>
        <option value="matt">영어, 남성</option>
        <option value="clara">영어, 여성</option>
        <option value="carmen">스페인어, 여성</option>
        <option value="meimei">중국어, 여성</option>
      </select>
      <input type="submit" value="결과 확인">
    </form>
    <br><br>
    <!-- 객체와 좌표 값 출력 -->
    TTS 결과 : <div id="resultDiv"></div>
    <br><br>
    <div><audio preload="auto" controls></audio></div>

    <a href="/">index 페이지로 이동</a>
  </body>
</html>