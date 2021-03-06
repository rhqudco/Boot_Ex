<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>OCR</title>
		<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
		<script src="/js/ocr.js"></script>
	</head>
	<body>
		<!--  파일 업로드 -->
		<h3>OCR : 텍스트 추출</h3>
		<form id="ocrForm" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile"> 
			<input type="submit" value="결과 확인">		
		</form>
		<br><br>
		
		<!-- 결과 출력 (텍스트) -->
		<h3>OCR : 텍스트 추출 결과</h3>
		<div id="resultDiv"></div>
		<br><br>
		
		<!-- 이미지 출력 (새로운 방법으로 알려줄 것임)  -->
		<h3>OCR : 원본 이미지 파일</h3>
		<div id="resultImg"></div>

		<br><br>
		<a href="/">index 페이지로 이동</a>
	</body>
</html>