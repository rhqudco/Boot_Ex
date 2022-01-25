$(function () {
    // submit 했을 때 처리
    $('#sttForm').on('submit', function (event) {
        event.preventDefault();
        var formData = new FormData($('#sttForm')[0]);
        var fileName = $('#uploadFile').val().split("\\").pop();
        $('audio').prop("src", '/voice/' + fileName);
        $.ajax({
            type : "post",
            enctype : "multipart/form-data",
            url : "stt2",
            data : formData,
            processData : false, // 필수
            contentType : false, // 필수
            success:function (result) {
                $('#resultDiv').text(result);
            },
            error:function (e) {
                alert("오류 발생" + e);
            }
        });
    })
})