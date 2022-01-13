<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 : index</title>
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
<%--    TOP    --%>
        <jsp:include page="/WEB-INF/views/layout/top.jsp" flush="true" />
        <section>
            <article id="slideShow">
                <!-- 이전, 다음 버튼 -->
                <div id="prevNextButtonBox">
                    <img src="/images/prevButton.png" id="prevButton">
                    <img src="/images/nextButton.png" id="nextButton">
                </div>
                <div id="slideShowBox">
                    <div id="slidePanel">
                        <img src="/images/slide_img_01.jpg" class="slideImage">
                        <img src="/images/slide_img_02.jpg" class="slideImage">
                        <img src="/images/slide_img_03.jpg" class="slideImage">
                        <img src="/images/slide_img_04.jpg" class="slideImage">
                        <img src="/images/slide_img_05.jpg" class="slideImage">
                    </div>
                </div>
                <!-- slideShowBox 끝 -->
                <div id="controlPanel">
                    <img src="/images/controlButton1.png" class="controlButton">
                    <img src="/images/controlButton1.png" class="controlButton">
                    <img src="/images/controlButton1.png" class="controlButton">
                    <img src="/images/controlButton1.png" class="controlButton">
                    <img src="/images/controlButton1.png" class="controlButton">
                </div>
            </article>

            <article id="content1"> <!-- 텝 메뉴 -->
                <div id="tabMenuBox">
                    <div id="tabMenu">
                        <ul id="tab">
                            <li><img src="/images/tab1.png"></li>
                            <li><img src="/images/tab2.png"></li>
                            <li><img src="/images/tab3.png"></li>
                            <li><img src="/images/tab4.png"></li>
                        </ul>
                    </div>
                    <div id="tabContent">
                        <div><a href="#"><img src="/images/tab_img_01.jpg"></a></div>
                        <div><a href="#"><img src="/images/tab_img_02.jpg"></a></div>
                        <div><a href="#"><img src="/images/tab_img_03.jpg"></a></div>
                        <div><a href="#"><img src="/images/tab_img_04.jpg"></a></div>
                    </div>
                </div>
            </article>

            <article id="content2"> <!-- 베스트 상품 -->
                <div id="productBox">
                    <h3>베스트 상품</h3>
                    <div class="product">
                        <div><a href=""><img src="/images/prd01.jpg"></a></div>
                        <div><a href=""><img src="/images/prd02.jpg"></a></div>
                        <div><a href=""><img src="/images/prd03.jpg"></a></div>
                    </div>
                    <div class="product">
                        <div><a href=""><img src="/images/prd04.jpg"></a></div>
                        <div><a href=""><img src="/images/prd05.jpg"></a></div>
                        <div><a href=""><img src="/images/prd06.jpg"></a></div>
                    </div>
                </div>
            </article>
        </section>
<%--  BOTTOM  --%>
        <jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
    </div>
</body>
</html>