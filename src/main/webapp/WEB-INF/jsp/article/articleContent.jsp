<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=0.3">
    <title>帖子内容</title>
    <%@include file="../common/import.jsp" %>
</head>
<body>
<div class="container" style="box-shadow: 0px 0px 1px #666;">
    <%@include file="../common/head.jsp" %>
    <div class="page-header">
        <h4><c:out value="${article.title}"/></h4>
    </div>
    <div class="row">
        <div class="panel panel-default" style="border-radius : 0;">
            <div class="panel-body">
                <div class="col-md-2">
                    <center>
                        <a href="${pageContext.request.contextPath}/user/info/${article.user.userId}" target="_blank">
                            <img alt="headimg" style="width: 111px;" src="<c:url value="${article.user.heading}"/>"
                                 class="img-thumbnail"></a>
                        <br><br>楼主 :<a href="${pageContext.request.contextPath}/user/info/${article.user.userId }"
                                       target="_blank">${article.user.username}</a>
                    </center>
                </div>
                <div class="col-md-8">
                    <c:out value="${article.content }" escapeXml="false"/>
                </div>
            </div>
            <h6 style="float: right;">
                发布时间:
                <fmt:formatDate value="${article.date }"
                                pattern="MM/dd HH:mm:ss"/>&nbsp;
            </h6>
        </div>
    </div>

    <h5>共${fn:length(commentList) }条评论</h5>

    <%-- 评论列表 --%>
    <c:forEach var="c" items="${commentList }" varStatus="st">
        <div class="row">
            <div class="panel panel-default" style="border-radius : 0;">
                <div class="panel-body">
                    <div class="col-md-2">
                        <center>
                            <a href="${pageContext.request.contextPath}/user/info/${c.user.userId}" target="_blank">
                                <img alt="headimg" style="width: 111px;" src="<c:url value="${c.user.heading}"/>"
                                     class="img-thumbnail">
                            </a>
                            <br><br>
                            <c:if test="${c.user.userId eq article.user.userId }">楼主:</c:if>
                            <a href="${pageContext.request.contextPath}/user/info/${c.user.userId}"
                               target="_blank">${c.user.username }</a>
                        </center>
                    </div>
                    <div class="col-md-8">
                        <c:out value="${c.content }" escapeXml="false"/>
                        <br><br>
                        <hr/>
                            <%-- 楼中楼评论数据 --%>
                        <div class="media" id="media${c.commentId }">
                            <c:forEach var="f" items="${c.floors}">
                                <c:if test="${f.commentId eq c.commentId }">
                                    <!-- 头像 -->
                                    <div class="media-left">
                                        <a href="${pageContext.request.contextPath}/user/info/${f.user.userId}" target="_blank">
                                            <img class="media-object" style="width: 34px;"
                                                 src="<c:url value="${f.user.heading }"/>">
                                        </a>
                                    </div>
                                    <!-- 评论内容 -->
                                    <div class="media-body">
                                        <a href="${pageContext.request.contextPath}/user/info/${f.user.userId}"
                                           target="_blank">${f.user.username }</a>:<c:out
                                            value="${f.content }"/>
                                    </div>
                                    <br>
                                </c:if>
                            </c:forEach>

                        </div>
                    </div>
                </div>
                <div class="replyMsg">
                    <h6 style="float: right;">
                            <%-- ${fn:length(commentList)-st.index }楼 --%>
                            ${st.index+1 }楼
                        <fmt:formatDate value="${c.date }"
                                        pattern="MM/dd HH:mm:ss"/>
                        <a onclick="openFloorInput(${c.commentId })">&nbsp;回复&nbsp;</a>
                    </h6>
                </div>
            </div>


                <%-- 楼中楼评论框 --%>
            <br>
            <div class="floor" id="floor${c.commentId }" style="display: none;width: 40%;float: right;">
                <textarea class="form-control" rows="3" id="text${c.commentId }"></textarea>
                <input class="btn btn-primary" type="submit" onClick="floorReply(${c.commentId})" value="回复"
                       style="float: right;">
            </div>
        </div>
    </c:forEach>

    <%-- 评论框 --%>
    <c:choose>
        <c:when test="${!empty user }">
            <div style="padding-top: 300px;">
                <div id="content" style="height:240px;"></div>
                <br>
                <button type="button" class="btn btn-primary" id="addbtn"
                        onclick="reply()" style="float: right;">回复
                </button>
            </div>
        </c:when>
        <c:otherwise>
            <center>
                <h3>登陆后才可进行回帖！</h3>
            </center>
        </c:otherwise>
    </c:choose>
    <%@include file="../common/foot.jsp" %>
    <%@include file="../common/editor.jsp" %>
</div>
<script type="text/javascript">
    /*回帖*/
    function reply() {
        var url = "${pageContext.request.contextPath}/comment/add";
        var params = {
            content: editor.$txt.html(),
            articleId: '${article.articleId }',
            userId: '${sessionScope.user.userId}'
        };
        $.post(url, params, function (data) {
            alert(data.data);
            location.href = "${pageContext.request.contextPath}/article/details/${article.articleId}";
        }, "json");
    }
    /*楼中楼回复框*/
    function openFloorInput(num) {
        $('#floor' + num).slideToggle();
        $('#text' + num).focus();
    }
    function floorReply(num) {
        //文本框内容
        var t = $('#text' + num).val();
        //请求服务器,插入评论
        var url = "${pageContext.request.contextPath}/article/floor/add";
        var params = {
            commentId: num,
            articleId: ${article.articleId },
            userId: '${sessionScope.user.userId}',
            content: t
        };
        $.ajax({
            'url': url,
            'data': params,
            'type': 'POST',
            'success': function (data) {
                //js插入评论数据
                var t1 = '<div class="media-left">' +
                    '<a href="${pageContext.request.contextPath}/user/info/${sessionScope.user.userId}"><img class="media-object" src="${pageContext.request.contextPath}/${sessionScope.use.heading }" style="width:34px;"></a>' +
                    '</div>' +
                    '<div class="media-body">' +
                    '<a href="${pageContext.request.contextPath}/user/info/${sessionScope.user.userId}" target="_blank">${sessionScope.user.username }</a>:' + t +
                    '</div>';
                $('#media' + num).append(t1);
                $('#text' + num).val('');
                $('#floor' + num).slideUp();
            },
            'error': function () {
                alert("回复失败！");
            }
        });
    }
</script>
</body>
</html>
