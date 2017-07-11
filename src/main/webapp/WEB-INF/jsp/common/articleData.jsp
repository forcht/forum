<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="${pageContext.request.contextPath}/article/details/${t.articleId}" target="_blank">
    <c:out value="${t.title }"/>
</a>
<div style="float: right;">
    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
    <a href="${pageContext.request.contextPath}/user/info/${t.user.userId}" target="_blank">${t.user.username }</a>
</div>
<br/>
</h4>
<c:if test="${!empty t.lable }">
    <span class="label label-success">#${t.lable }#</span>
</c:if>
<p style="float: right;">
    <fmt:formatDate value="${t.date}" pattern="MM/dd HH:mm:ss"/>
</p>
<br>