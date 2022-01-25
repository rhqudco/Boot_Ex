$(function () {
    // submit 했을 때 처리
    $('#ttsForm').on('submit', function (event) {
        event.preventDefault();
        var formData = new FormData($('#ttsForm')[0]);
        var fileName = $('#uploadFile').val().split("\\").pop();

        $.ajax({
            type : "post",
            enctype : "multipart/form-data",
            url : "clovaTTS",
            data : formData,
            processData : false, // 필수
            contentType : false, // 필수
            success:function (result) {
                $('audio').prop("src", '/images/' + result);
                $('#resultDiv').text(result); // 저장된 음성 파일명
            },
            error:function (e) {
                alert("오류 발생" + e);
            }
        });
    })
})