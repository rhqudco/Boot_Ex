$(function() {
    $(window).on('scroll', function() {
        // 스크롤 되는 문서의 top이 #headerBox 이상이면 메인메뉴 고정되고 그림자 표시
        if($(document).scrollTop() >= $('#headerBox').height()) {
            $('#mainMenuBox').addClass('mainMenuFixed mainMenuShadow');
        }
        else {
            $('#mainMenuBox').removeClass('mainMenuFixed mainMenuShadow');
        }
    });
    $('#moveToTop').on('click', function() {
        $('html, body').animate({scrollTop:0}, 500);
    })
});