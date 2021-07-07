$(function (){
    // 禁止输入空白符
    $('#uname').on('keyup', function () {
        $(this).val($(this).val().replace(/\s+/g,''));
    });
    $('#pwd').on('keyup', function () {
        $(this).val($(this).val().replace(/\s+/g,''));
    });

    // 检测用户名和密码是否填写
    $(".btn").on('click', function () {
        if ($('#uname').val() == '' || $('#pwd').val() == '') {
            alert('用户名或密码不能为空');
            return false;
        }
    });
})