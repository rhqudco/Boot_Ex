$(function(){
	var $tabContent = $('#tabContent div');
	// 첫 번째 항목 선택되어 있게 설정
	$('#tab li:first-child').addClass('selectedItem');
	
	$('#tab li').on('click', function(){
		var index = $(this).index();
        // 탭메뉴 항목을 선택된 이미지로 변경
        // 모든 탭메뉴 항목에 선택시 적용된 css 효과 제거
		$('#tab li').removeClass('selectedItem');
		// 클릭한 항목에만 선택한 css 효과 설정
		$(this).addClass('selectedItem');
		// content 이미지 변경 
        // content의 모든 div 숨김
		$tabContent.css('display', 'none');
		//클릭한 탭메뉴 항목의 index에 해당되는 div만 보임
		$tabContent.eq(index).css('display', 'block');
	});
});