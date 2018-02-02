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
          href="<%=request.getContextPath()%>/resources/css/addTeacher.css">
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
                <form id="addTeacherForm" action="<%=basePath%>admin/teachers/add" method="post">
                    <p>请在下面录入导师信息,确认无误后点击确定按钮提交!</p>
                    <table class="table table-hover">
                        <tr>
                            <td><label for="teacherName">姓名&nbsp</label><input type="text" name="teacherName" id="teacherName"></td>
                            <td><label for="insName">学院&nbsp</label><input type="text" name="insName" id="insName"></td>
                            <td rowspan="2">
                                <img id="tImg" src="<%=request.getContextPath()%>/resources/image/test.png">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="gender">性别&nbsp</label><select id="gender" name="gender">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select></td>
                            <td><label for="title">职称&nbsp</label><input type="text" name="title" id="title"></td>
                        </tr>
                    </table>

                    <p><label for="introduction">导师简介:</label></p>
                    <textarea id="introduction" name="introduction" cols="120" rows="5"></textarea>
                    <br/>
                    <p><label for="recommendation">学生推荐:</label></p>
                    <textarea id="recommendation" name="recommendation" cols="120" rows="5"></textarea>
                    <br />
                    <p><label for="comment">一句话点评:</label></p>
                    <textarea id="comment" name="comment" cols="120" rows="2"></textarea>
                    <br /><br />
                    <div class="center">
                        <button type="button" class="btn btn-danger" onclick="addTeacher.goToTeachers('<%=basePath%>')">取消</button>
                        <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                        <input type="submit" name="submit" value="提交" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/addTeacher.js">

</script>
</html>

