<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>카테고리별 제품 정보</title>
        <link rel="stylesheet" href="/css/common.css" type="text/css">
        <link rel="stylesheet" href="/css/index.css" type="text/css">
        <link rel="stylesheet" href="/css/menu.css" type="text/css">
        <link rel="stylesheet" href="/css/slideShow.css" type="text/css">
        <link rel="stylesheet" href="/css/tabMenu.css" type="text/css">
        <link rel="stylesheet" href="/css/product.css" type="text/css">
        <script src="/js/jquery-3.6.0.min.js"></script>
        <script src="/js/subMenu.js"></script>
        <script src="/js/slideShow.js"></script>
        <script src="/js/tabMenu.js"></script>
        <script src="/js/index.js"></script>
    </head>
    <body>
        <div id="wrap">
            <!--   TOP   -->
            <jsp:include page="/WEB-INF/views/layout/top.jsp" flush="true" />
            <!--  로그인 폼  -->
            <section>
                <h3>상품 목록</h3>
                <table border="1" width="800" align="center">
                    <tr><th>상품번호</th><th>사진</th><th>상품명</th><th>가격</th>
                        <th>제조사</th><th>재고</th></tr>
                    <c:forEach items="${prdList }" var="prd">
                        <tr><td><a href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>">${prd.prdNo }</a></td>
                            <td><img src="<c:url value='/prdImages/${prd.prdImg}'/>" width="300" height="200"></td>
                            <td>${prd.prdName }</td>
                            <td>${prd.prdPrice }</td>
                            <td>${prd.prdCompany }</td>
                            <td>${prd.prdStock }</td>
                        </tr>
                    </c:forEach>
                </table>
            </section>
            <!--   BOTTOM   -->
            <jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
        </div>
    </body>
</html>
