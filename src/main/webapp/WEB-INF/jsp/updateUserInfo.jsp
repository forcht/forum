<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/10
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>updateUserInfo</title>
</head>
<body>
<form action="/Forum/from/updateUserInfo" method="post" onsubmit="return updateUserInfo()" enctype="multipart/form-data">
    <table border="1" align="center" width="25%">
        <caption>修改用户信息</caption>
        <tr>
            <td>用户头像</td>
            <td>
                <img src="${pageContext.request.contextPath}${user.heading}" width="80" height="80" id="image">
                <input type="file" name="file" id="file">
            </td>
        </tr>
        <tr>
            <td>用户ID</td>
            <td>
                <input type="text" name="userId" id="userId" value="${user.userId}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="email" name="email" id="email" value="${user.email}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" id="username" value="${user.username}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="保存">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
