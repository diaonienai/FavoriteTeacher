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
          href="<%=request.getContextPath()%>/resources/css/teachers.css">
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
                <form id="teachersForm" action="#" method="post">
                    <input type="hidden" name="currentPage" value="${page.currentPage}">
                    <%--导师表格--%>
                    <table class="table table-hover">
                        <%--表格第一行,包括全选按钮,添加按钮,删除按钮--%>
                        <tr>
                            <td><input type="checkbox" id="chooseAll" name="chooseAll" onclick="teachers.chooseAll(this)">
                                <label for="chooseAll">全选</label></td>
                            <td><input type="button" id="btnInsert" name="btnInsert" value="添加" onclick="teachers.goToAddPage('<%=basePath%>')"></td>
                            <td><input type="button" id="btnDelete" name="btnDelete" value="删除" onclick="teachers.delete('<%=basePath%>')"></td>
                        </tr>
                        <%--表格第二行,表头    --%>
                        <tr>
                            <td></td>
                            <td>照片</td>
                            <td>导师名字</td>
                            <td>所在学院</td>
                            <td>操作</td>
                        </tr>
                        <%--遍历显示当前页所有导师    --%>
                        <c:forEach items="${teachers}" var="t">
                            <tr>
                                <td><label><input type="checkbox" name="ids" value="${t.teacherNo}"></label></td>
                                <td><img id="tImg" src="<%=request.getContextPath()%>/resources/image/test.png"></td>
                                <td>${t.teacherName}</td>
                                <td>${t.institute.insName}</td>
                                <td><input type="button" value="编辑"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <%--表格最后一行,显示分页相关--%>
                    <div class="text-center">
                        <span>共<b>${page.totalNumber}</b>条</span>
                            <c:if test="${page.currentPage!=1}">
                                <a onclick="teachers.changePage('<%=basePath%>',1)">首页</a>
                                <a onclick="teachers.changePage('<%=basePath%>',${page.currentPage-1})">上一页</a>
                            </c:if>
                        <span>当前第${page.currentPage}/${page.totalPage}页</span>
                        <c:if test="${page.currentPage!=page.totalPage}">
                            <a onclick="teachers.changePage('<%=basePath%>',${page.currentPage+1})">下一页</a>
                            <a onclick="teachers.changePage('<%=basePath%>',${page.totalPage})">末页</a>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/teachers.js">

</script>
</html>

