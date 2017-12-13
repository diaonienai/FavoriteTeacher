<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css"
      href="<%=request.getContextPath()%>/resources/css/leftNav.css">

<%--左边导航栏--%>
<form id="leftNavForm" action="/favorite/admin/jump" method="post">
    <input type="hidden" name="pageIndex" value="${pageIndex}">
    <ul class="nav navbar-nav">
        <li><a onclick="leftNav.tab(0)">更新导师信息</a></li>
        <li><a onclick="leftNav.tab(1)">更新活动介绍</a></li>
        <li><a onclick="leftNav.tab(2)">管理学生留言</a></li>
        <li><a onclick="leftNav.tab(3)">更新网站样式</a></li>
    </ul>
</form>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/leftNav.js">

</script>
