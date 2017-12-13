var leftNav = {

    // 处理tab标签页
    tab : function(params){

        var form = $("#leftNavForm");
        var page_index = $("form input[name='pageIndex']");
        page_index.val(params);
        form.submit();

    }

};