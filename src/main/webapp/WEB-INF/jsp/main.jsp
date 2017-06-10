<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/10
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.forum.entity.User" %>
<%User user= (User) session.getAttribute("user");%>
<html>
<head>
    <title>main</title>
</head>
<body>
<img src="${pageContext.request.contextPath}<%=user.getHeading()%>">
<button type="button">修改资料</button>
<br>
<p><%=user.getUsername()%></p>
<p><%=request.getAttribute("data")%></p>
</body>
</html>
