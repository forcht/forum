<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/8
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
<form action="/Forum/from/login" method="post" onsubmit="return login()">
    <label>用户名</label>
    <input id="username" type="text" name="username" placeholder="请输入您的用户名"><br>
    <label>密&nbsp&nbsp码</label>
    <input id="password" type="password" name="password" placeholder="请输入您的密码"><br>
    <input id="remember" type="checkbox" name="remember">记住我<br>
    <input type="submit" value="确定">
    <input type="reset" value="重设">
    <a href="/Forum/to/register">注册</a>
</form>
</body>
</html>
