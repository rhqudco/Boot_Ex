<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Title</title>
  </head>
  <body>
    <h3>index.jsp 페이지 입니다.</h3>
    <img src="/images/obong.jpg" style="width: 300px">
    <h3>MyBatis 사용 DB 연동</h3>
    <h4>상품 관리 시스템</h4>
    <a href="product/listAllProduct">전체 상품 조회</a><br><br>
    <a href="product/newProductForm">상품 등록</a><br><br>
    <a href="product/productSearchForm">상품 검색</a><br><br>
    <a href="product/productSearchForm2">상품 검색2</a><br><br>
    <a href="product/productSearchForm3">상품 검색3(RestController)</a><br><br><br><br>
    <hr>
    <h3>파일 업로드</h3>
    <a href="upload/fileUploadForm">파일 업로드</a><br>
    <hr>
    <h3>파일 다운로드</h3>
    <a href="download/fileDownloadListView">파일 다운로드</a>
  </body>
</html>
