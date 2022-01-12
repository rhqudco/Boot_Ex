<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>여러 개의 파일 업로드 결괴</title>
  </head>
  <body>
  다음의 파일을 전송하였습니다.<br>
  <c:forEach items="${originalFileNameList}" var="file">
      ${file} <br>
  </c:forEach><br>
  (서버에만 출력) Users/gobyeongchae/Desktop/UploadServerFile 확인
  </body>
</html>
