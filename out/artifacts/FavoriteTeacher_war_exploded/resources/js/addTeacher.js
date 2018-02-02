var addTeacher = {

    teacherURL : "admin/teachers",
    addURL : "admin/teachers/add",

    /**
     * 跳转到教师列表页
     */
    goToTeachers : function (basePath) {
        window.location.href = basePath+ addTeacher.teacherURL;
    }

};