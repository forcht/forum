<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="search" style="float: right;padding-right: 35px;">
    <form action="${pageContext.request.contextPath}/article/search" method="post" class="navbar-form navbar-left"
          role="search" style="float: right;">
        <input type="text" name="key" class="form-control" placeholder="Search">
        <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-search"></span> 搜索
        </button>
    </form>
</div>
