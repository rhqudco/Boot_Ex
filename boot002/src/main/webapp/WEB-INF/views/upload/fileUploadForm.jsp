<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>파일 업로드 폼</title>
  </head>
  <body>
    <h3>파일 업로드 (파일명 중복되지 않도록 파일 이름 변경해서 업로드)</h3>
    <form id="fileUploadForm" method="post" action="/upload/fileUpload" enctype="multipart/form-data">
      파일 : <input type="file" id="uploadFile" name="uploadFile"><br><br>
      <input type="submit" value="업로드">
    </form> <br>

    <hr>

    <h3>파일 업로드 (여러 개 파일 업로드)</h3>
    <form id="fileUploadFormMulti" method="post" action="/upload/fileUploadMultiple" enctype="multipart/form-data">
      파일 : <input type="file" id="uploadFileMulti" name="uploadFileMulti" multiple="multiple"><br><br>
      <input type="submit" value="업로드">
    </form> <br>

    <hr>

    <h3>파일 업로드 (원본 파일명 그대로 업로드)</h3>
    <form id="fileOriginalNameUpload" method="post" action="/upload/fileOriginalNameUpload" enctype="multipart/form-data">
      파일 : <input type="file" id="uploadFileOrigin" name="uploadFileOrigin" ><br><br>
      <input type="submit" value="업로드">
    </form> <br>
  </body>
</html>
