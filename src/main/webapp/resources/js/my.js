/**
 * Created by haitang on 2017/6/8.
 */
/**
 * 处理登录
 */
function login() {
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    //var remember=document.getElementById("remember");
    if(username.value==""){
        alert("请输入用户名");
    }else if (password.value==""){
        alert("请输入密码");
    } else {
        var url = "user/login";
        var params = {
            username : $('#username').val(),
            password : $('#password').val()
            //remember : $('#remember').val()
        };
        $.post(url, params, function(data) {
            alert(data.data);
            location.href = "article/list/1";
        }, "json");
    }

}
/**
 * 处理注册
 */
function register() {
    var email=document.getElementById("email");
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var password2=document.getElementById("password2");
    if(email.value==""){
        alert("请输入邮箱");
    }
    else if(username.value==""){
        alert("请输入用户名");
    }else if (password.value==""){
        alert("请输入密码");
    } else if(password2.value=="") {
        alert("请再次输入密码");
        return false;
    }else if (password.value!=password2.value){
        alert("两个输入的密码不一样");
    } else{
        var url = "user/register";
        var params = {
            email   :  $('#email').val(),
            username : $('#username').val(),
            password : $('#password').val()
        };
        $.post(url, params, function(data) {
            alert(data.data);
        }, "json");
    }
}

/**
 * 修改用户信息
 * @returns {boolean}
 */
function updateUserInfo() {
    var username=document.getElementById("username");
    if(username.value==""){
        alert("请输入用户名");
        return false;
    }
    return true;
}