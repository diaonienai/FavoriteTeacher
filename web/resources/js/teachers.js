var teachers = {

    changePageURL : "admin/teachers",
    deleteURL : "admin/teachers/delete",
    addPageURL : "admin/teachers/addPage",

    /**
     * 分页功能，根据页码跳转
     */
    changePage : function(basePath, position){
        $("#teachersForm").attr("action",basePath + teachers.changePageURL);
        $("#teachersForm input[name='currentPage']").val(position);
        $("#teachersForm").submit();
    },

    /**
     * 全选按钮点击事件
     */
    chooseAll : function(obj){
        if(obj.checked){
            //点击全选
            $("#teachersForm input[name='ids']").each(function(){
                $(this).unbind("click");
                this.checked = true;
                $(this).click(function(){
                    // console.log(index+": "+this.checked);
                    if(!this.checked) {
                        obj.checked = false;
                    }
                });
            });
        }else {
            //取消全选
            $("#teachersForm input[name='ids']").each(function(){
                $(this).unbind("click");
                this.checked = false;
            });
        }
    },

    /**
     * 删除按钮点击事件
     */
    delete : function(basePath){
        $("#teachersForm").attr("action",basePath + teachers.deleteURL);
        $("#teachersForm").submit();
    },

    /**
     * 跳转至添加页面
     */
    goToAddPage : function(basePath){
        window.location.href = basePath+ teachers.addPageURL;
    }

};