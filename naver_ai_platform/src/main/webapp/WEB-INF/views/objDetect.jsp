<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Object Detect</title>
		<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
		<script src="js/objDetect.js"></script>
	</head>
	<body>
		<!--  파일 업로드 -->
		<h3>포즈 인식</h3>
		<form id="objectForm" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인">
		</form>
		<br><br>
		<!-- 결과 출력  -->
		<h3>포즈 인식 결과를 이미지에 좌표로 표시</h3>
		<canvas id="objectCanvas" width="600" height="600"></canvas>
		<br><br>
		<!-- 객체와 좌표 값 출력 -->
		<div id="resultDiv"></div>
		<br><br>
		<a href="/">index 페이지로 이동</a>
	</body>
</html>