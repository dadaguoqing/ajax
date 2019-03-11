$(document).ready(function () {
    getProvinces();
});

function getProvinces() {
    $.post('/ajax1/province.do', function (data) {
        var pros = JSON.parse(data);
        // 遍历pros数组,将内容加载都pro下拉选中
        $.each(pros, function (index, item) {
            $('#province').append(
                $('<option value="' + item.code
                    + '">' + item.name
                    + '</option>'))
        })
    });
    // $.ajax({
    //     url: '/ajax1/province.do',
    //     type: 'get',
    //     dataType: 'text',
    //     success: function (data) {
    //         var pros = JSON.parse(data);
    //         // 遍历pros数组,将内容加载都pro下拉选中
    //         for (var index = 0; index < pros.length; index++) {
    //             $('#province').append(
    //                 $('<option value="' + pros[index].code
    //                     + '">' + pros[index].name
    //                     + '</option>'))
    //         }
    //     }
    // });

}

function changeCity(code) {
    $.get("/ajax1/city.do", {code: code}, function (data) {
        var cities = JSON.parse(data);
        // 追加城市信息,先清掉之前的内容
        $('#city').empty();
        $('#city').append('<option value="-1"> - 请选择城市 - </option>');
        $.each(cities, function (index, item) {
            $('#city').append($('<option value="' + item.code + '">' + item.name + '</option>'));
        })
    });

    // $.ajax({
    //     type: "get",
    //     url: "/ajax1/city.do",
    //     data: {code: code},
    //     dataType: "text",
    //     async: true,
    //     success: function (data) {
    //         var cities = JSON.parse(data);
    //         // 追加城市信息,先清掉之前的内容
    //         $('#city').empty();
    //         $('#city').append('<option value="-1"> - 请选择城市 - </option>');
    //         for (var index = 0; index < cities.length; index++) {
    //             $('#city').append($('<option value="' + cities[index].code + '">' + cities[index].name + '</option>'));
    //         }
    //     }
    // });
}

function changeArea(code) {
    $.post("/ajax1/area.do", {code: code}, function (data) {
        var areas = JSON.parse(data);
        $('#area').empty();
        $('#area').append('<option value=-1> - 请选择区域 - </option>');
        $.each(areas, function (index,item) {
            $('#area').append('<option value= "' + item.code + '">' + item.name + '</option>');
        })
    });

    // $.ajax({
    //     url: "/ajax1/area.do",
    //     type: "post",
    //     data: {code: code},
    //     dataType: "text",
    //     async: false,
    //     success: function (data) {
    //         var areas = JSON.parse(data);
    //         $('#area').empty();
    //         $('#area').append('<option value=-1> - 请选择区域 - </option>');
    //         for (var index = 0; index < areas.length; index++) {
    //             $('#area').append('<option value= "' + areas[index].code + '">' + areas[index].name + '</option>');
    //         }
    //     }
    // });

}