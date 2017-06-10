/**
 * Created by haitang on 2017/6/8.
 */
/**
 * 处理登录的表单
 * @returns {boolean}
 */
function login() {
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var remember=document.getElementById("remember");
    if(username.value==""){
        alert("请输入用户名");
        return false;
    }else if (password.value==""){
        alert("请输入密码");
        return false;
    } else {
        alert(username.value+password.value+remember.checked);
        return true;
    }
    return false;
}
/**
 * 处理注册的表单
 * @returns {boolean}
 */
function register() {
    var email=document.getElementById("email");
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var repassword=document.getElementById("repassword");
    if(email.value==""){
        alert("请输入邮箱");
        return false;
    }
    else if(username.value==""){
        alert("请输入用户名");
        return false;
    }else if (password.value==""){
        alert("请输入密码");
        return false;
    } else if(repassword.value=="") {
        alert("请再次输入密码");
        return false;
    }else if (password.value!=repassword.value){
        alert("两个输入的密码不一样");
        return false;
    } else{
        alert(email.value+username.value+password.value+repassword.value);
        return true;
    }
    return false;
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