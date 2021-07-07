$(function () {
    // 屏蔽空白输入
    $('#name').on('keyup', function () {
        $(this).val($(this).val().replace(/\s+/g,''));
    });
    $('#score').on('keyup', function () {
        $(this).val($(this).val().replace(/\s+/g,''));
    });

    // 判断用户信息是否为空
    $('.btn').on('click', function () {
        if ($('#name').val() == '' || $('#score').val() == '' || $('#date').val() == '') {
            alert('姓名,成绩,和日期不能为空!');
            return false;
        }
    });
})