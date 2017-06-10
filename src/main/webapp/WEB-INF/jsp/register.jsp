<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/8
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<br>
<form action="/Forum/from/register" method="post" onsubmit="return register();">
    <table border="1" align="center" width="25%">
        <caption>用户注册</caption>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="email" name="email" id="email">
            </td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password" id="password">
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="repassword" id="repassword">
            </td>
        </tr>
        <c:set var="data" scope="page" value="${data}"/>
        <c:if test="${ not empty data}">
           <tr>
               <td>
                   <label id="tip" style="color: #f81c2e">${data}</label>
               </td>
           </tr>
        </c:if>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重设">&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/Forum/to/login">登录</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
