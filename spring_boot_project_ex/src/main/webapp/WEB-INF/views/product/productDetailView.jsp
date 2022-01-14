<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>상품 상세 정보 조회</title>
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
        <script type="text/javascript">
            var qty = 1;
            function qtyChange(num) {
                qty = qty + num;
                if(qty < 1) qty = 1; // 주문 수량이 0 이하가 되지 않도록.
                calAmount();
            }
            // 주문액 계산
            function calAmount() {
                var cartQty = document.getElementById('cartQty'); // 주문수량 값 읽어오기
                var amount = document.getElementById('amount'); // 주문액 출력
                // 주문액 계산
                var total = qty * ${prd.prdPrice};
                // 계산액 출력
                cartQty.value = qty;
                amount.innerHTML = total.toLocaleString();
            }
        </script>
    </head>
    <body>
    <div id="wrap">
        <!--   TOP   -->
        <jsp:include page="/WEB-INF/views/layout/top.jsp" flush="true" />
        <!--  로그인 폼  -->
        <section>
            <h3>상품 상세 정보 조회</h3>
            <form method="post" action="<c:url value='/product/insertCart'/>"  >
            <table border="1" width="800">
                <tr><td rowspan="9"><img src="<c:url value='/prdImages/${prd.prdImg}'/>" width="300" height="250"></td></tr>
                <tr><td>상품번호</td><td><input type="hidden" name="prdNo" value="${prd.prdNo}">${prd.prdNo}</td></tr>
                <tr><td>상품명</td><td>${prd.prdName}</td></tr>
                <tr><td>가격</td><td><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###" /></td></tr>
                <tr><td>제조사</td><td>${prd.prdCompany}</td></tr>
                <tr><td>상품설명</td><td>${prd.prdDescript}</td></tr>
                <tr><td>주문수량</td>
                    <td>
                        <input type="button" value=" - " onclick="qtyChange(-1)">
                        <input type="text" id="cartQty" name="cartQty" value="1" size="4" readonly> 개
                        <input type="button" value=" + " onclick="qtyChange(1)">
                    </td></tr>
                <tr><td>구매 예정 금액</td>
                    <td><span id="amount"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###" /></span> 원</td></tr>
                <tr><td colspan="2" align="center">
                    <!-- 로그인 하지 않은 경우 [로그인] 버튼 출력 -->
                    <c:if test ="${empty sessionScope.sid}">
                        <button><a href="<c:url value='/loginForm'/> " style="text-decoration-line: none" >로그인</a></button>
                    </c:if>
                    <!-- 로그인한 경우 [장바구니] [주문하기] 버튼 출력 -->
                    <c:if test ="${not empty sessionScope.sid}">
                        <input type="submit" id="insertCart" value="장바구니">
                        <input type="button" id="insertOrder" value="주문하기">
                    </c:if>
                    </td></tr>
            </table>
            </form>
            <br>
            <a href="<c:url value='/product/listCtgProduct/${prd.ctgId }'/>"><button>상품 목록</button></a>
            <br>
            <br>
        </section>
        <!--   BOTTOM   -->
        <jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
    </div>
    </body>
</html>

