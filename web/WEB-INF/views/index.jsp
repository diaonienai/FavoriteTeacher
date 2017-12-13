<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
    <head>
      <title>$Title$</title>
      <%@include file="common/head.jsp" %>
  </head>
  <body>
  <div class="container">
      <div class="panel panel-default">
          <div class="panel-heading text-center"><h1>导师列表</h1></div>
          <div class="panel-body text-center">
              <table class="table table-hover">
                  <tr>
                      <th>id</th>
                      <th>教师名字</th>
                      <th>性别</th>
                      <th>职称</th>
                      <th>所属学院</th>
                      <th>获得票数</th>
                      <th>个人简介</th>
                      <th>推荐语</th>
                      <th>点评</th>
                  </tr>
                  <c:forEach var="item" items="${teachers}">
                      <tr>
                          <td>${item.teacherNo}</td>
                          <td>${item.teacherName}</td>
                          <td>${item.gender}</td>
                          <td>${item.title}</td>
                          <td>${item.institute.insName}</td>
                          <td>${item.votes}</td>
                          <td>${item.introduction}</td>
                          <td>${item.recommendation}</td>
                          <td>${item.comment}</td>

                      </tr>
                  </c:forEach>
              </table>
          </div>
      </div>
  </div>
  </body>
</html>
