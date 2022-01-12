<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Title</title>
  </head>
  <body>
    <c:forEach items="${fileList}" var="file">
        <a href="<c:url value='/fileDownload/${file}'/> ">${file} 파일 다운로드</a><br>
    </c:forEach>
  </body>
</html>