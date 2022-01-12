<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>상품 상세 정보 조회</title>
    </head>
    <body>
        <h3>상품 상세 정보 조회</h3>
        <table border="1" width="300">
            <tr><td>상품번호</td><td>${prd.prdNo}</td></tr>
            <tr><td>상품명</td><td>${prd.prdName}</td></tr>
            <tr><td>가격</td><td>${prd.prdPrice}</td></tr>
            <tr><td>제조사</td><td>${prd.prdCompany}</td></tr>
            <tr><td>재고</td><td>${prd.prdStock}</td></tr>
        </table> <br>

        <a href="<c:url value='/'/>">메인으로 이동</a> <br><br>
        <a href="<c:url value='/product/updateProductForm/${prd.prdNo}'/>">상품 정보 수정(c:url)</a><br><br>
        <a href="javascript:deleteCheck();" >상품 정보 삭제</a><br><br>
        <script type="text/javascript">
            function deleteCheck() {
                var answer = confirm("선택한 상품을 삭제하시겠습니까?");
                if(answer == true) {
                    location.href = "/product/deleteProduct/${prd.prdNo}";
                }
            }
        </script>
    </body>
</html>