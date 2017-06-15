<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/10
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<img src="${pageContext.request.contextPath}${user.heading}" width="80" height="80" id="image">
<p>${user.username}</p>
<br><br><br>
<table border="1" align="center" width="25%">
    <tr>
        <td colspan="4" align="center" bgcolor="#CED3FF">
            <h2>论坛</h2>
        </td>
    </tr>
    <tr>
        <th width="200px">留言者</th>
        <th width="300px">标题</th>
        <th width="50px">查看</th>
        <th width="50px">时间</th>
        <c:forEach items="${list}" var="article">
    <tr>
        <td><c:out value="${article.user.username}"/></td>
        <td><c:out value="${article.title}"/></td>
        <td><fmt:formatDate value="${article.date}" pattern="MM/dd HH:mm:ss"/></td>
        <td><a href="">查看</a></td>
    </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
