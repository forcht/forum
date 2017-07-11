<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 弹出注册对话框 -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">注册</h4>
            </div>
            <div class="modal-body">
                <input type="email" id="email" maxlength="20" class="form-control" placeholder="输入邮箱">
                <input type="text" id="username" maxlength="20"  class="form-control" placeholder="用户名"><br>
                <input type="password" id="password" maxlength="20"  class="form-control" placeholder="密码">
                <input type="password" id="password2" maxlength="20" class="form-control" placeholder="再次输入密码">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="register()">注册</button>
            </div>
        </div>
    </div>
</div>