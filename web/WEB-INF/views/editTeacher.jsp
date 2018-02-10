<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/resources/css/editTeacher.css">
    <%@include file="common/head.jsp" %>
</head>
<body>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center"><h3>后台管理页面</h3></div>
        <div class="row">
            <div class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
                <%--左边导航栏--%>
                <%@include file="leftNav.jsp"%>
            </div>
            <div class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
                <%--内容--%>
                <form id="editTeacherForm" action="<%=basePath%>admin/teachers/edit" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="teacherNo" value="${teacher.teacherNo}">
                    <input type="hidden" name="insNo" value="${teacher.institute.insNo}">
                    <input type="hidden" name="teacherIcon" value="${teacher.icon}">
                    <p>请在下面编辑导师信息,确认无误后点击确定按钮提交!</p>
                    <table class="table table-hover">
                        <tr>
                            <td><label for="teacherName">姓名&nbsp</label><input type="text" name="teacherName" id="teacherName" value="${teacher.teacherName}"></td>
                            <td><label for="insName">学院&nbsp</label><input type="text" name="insName" id="insName" value="${teacher.institute.insName}"></td>
                            <td rowspan="2" align="center">
                                <label for="tIcon"><img id="preview" width="100" height="120" src="${teacher.icon}"></label>
                                <br>
                                <label for="tIcon" class="btn btn-primary">选择头像</label>
                                <input type="file" id="tIcon" name="tIcon" style="display: none"
                                       onchange="editTeacher.imgPreview(this)"/>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="gender">性别&nbsp</label><select id="gender" name="gender">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select></td>
                            <td><label for="title">职称&nbsp</label><input type="text" name="title" id="title" value="${teacher.title}"></td>
                        </tr>
                    </table>

                    <p><label for="introduction">导师简介:</label></p>
                    <textarea id="introduction" name="introduction" cols="120" rows="5">${teacher.introduction}</textarea>
                    <br/>
                    <p><label for="recommendation">学生推荐:</label></p>
                    <textarea id="recommendation" name="recommendation" cols="120" rows="5">${teacher.recommendation}</textarea>
                    <br />
                    <p><label for="comment">一句话点评:</label></p>
                    <textarea id="comment" name="comment" cols="120" rows="2">${teacher.comment}</textarea>
                    <br /><br />
                    <div class="center">
                        <button type="button" class="btn btn-danger" onclick="editTeacher.goToTeachers('<%=basePath%>')">取消</button>
                        <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                        <input type="submit" name="submit" value="提交" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/editTeacher.js">

</script>
</html>

