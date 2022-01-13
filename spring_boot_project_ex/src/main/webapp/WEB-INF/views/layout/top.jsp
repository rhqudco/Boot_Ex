<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Top</title>
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
            <header>
                <div id="headerBox">
                    <div id="logoBox"><a href="<c:url value='/'/> "><img src="/images/logo.png" id="logoImg"></a></div>
                    <div id="topMenuBox">

                        <!-- 로그인 하기 전에 보여줄 메뉴 항목 -->
                        <c:if test="${empty sessionScope.sid}">
                            <a href="<c:url value='/loginForm'/> ">로그인</a>
                            이벤트 장바구니 고객센터
                            <a href="<c:url value='/joinForm'/> ">회원가입</a>
                        </c:if>

                        <!-- 로그인 성공 후에 보여줄 메뉴 항목 -->
                        <c:if test="${not empty sessionScope.sid}">
                            ${sessionScope.sid} 님 환영합니다! &nbsp;
                            <a href="<c:url value='/logout'/> ">로그아웃</a>
                            이벤트 장바구니 고객센터 MyPage
                            <a href="<c:url value='/joinForm'/> ">회원가입</a>
                        </c:if>
                    </div>
                </div>
            </header>
            <nav>
                <div id="mainMenuBox">
                    <ul id="menuItem">
                        <li><a href="#">SPECIAL</a></li>
                        <li><a href="#">메뉴 항목1</a></li>
                        <li><a href="#">메뉴 항목2</a></li>
                        <li><a href="#">메뉴 항목3</a></li>
                        <li><a href="#">메뉴 항목4</a></li>
                        <li><a href="#" id="showAllMenu">전체 보기</a></li>
                    </ul>
                </div>
                <!-- mainMenuBox 끝 -->
                <div id="subMenuBox">
                    <div class="subMenuItem" id="subMenuItem1">
                        <ul>
                            <li><a href="#">subMenuItem 1-1</a></li>
                            <li><a href="#">subMenuItem 1-2</a></li>
                            <li><a href="#">subMenuItem 1-3</a></li>
                            <li><a href="#">subMenuItem 1-4</a></li>
                        </ul>
                    </div>
                    <div class="subMenuItem" id="subMenuItem2">
                        <ul>
                            <li><a href="#">subMenuItem 2-1</a></li>
                            <li><a href="#">subMenuItem 2-2</a></li>
                            <li><a href="#">subMenuItem 2-3</a></li>
                            <li><a href="#">subMenuItem 2-4</a></li>
                        </ul>
                    </div>
                    <div class="subMenuItem" id="subMenuItem3">
                        <ul>
                            <li><a href="#">subMenuItem 3-1</a></li>
                            <li><a href="#">subMenuItem 3-2</a></li>
                            <li><a href="#">subMenuItem 3-3</a></li>
                            <li><a href="#">subMenuItem 3-4</a></li>
                        </ul>
                    </div>
                    <div class="subMenuItem" id="subMenuItem4">
                        <ul>
                            <li><a href="#">subMenuItem 4-1</a></li>
                            <li><a href="#">subMenuItem 4-2</a></li>
                            <li><a href="#">subMenuItem 4-3</a></li>
                            <li><a href="#">subMenuItem 4-4</a></li>
                        </ul>
                    </div>
                    <div class="subMenuItem" id="subMenuItem5">
                        <ul>
                            <li><a href="#">subMenuItem 5-1</a></li>
                            <li><a href="#">subMenuItem 5-2</a></li>
                            <li><a href="#">subMenuItem 5-3</a></li>
                            <li><a href="#">subMenuItem 5-4</a></li>
                        </ul>
                    </div>
                    <div class="subMenuItem" id="subMenuItem6">
                        <ul>
                            <li><a href="#">subMenuItem 6-1</a></li>
                            <li><a href="#">subMenuItem 6-2</a></li>
                            <li><a href="#">subMenuItem 6-3</a></li>
                            <li><a href="#">subMenuItem 6-4</a></li>
                        </ul>
                    </div>
                </div>
                <!-- subMenuBox 끝 -->
            </nav>
        </div>
        </body>
</html>
