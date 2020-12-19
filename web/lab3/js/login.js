window.onload=function (){
    var userName=document.getElementById("username");
    var userNameError=document.getElementById("username_error");
    userName.onblur=function (){
        var name=userName.value;
        name=name.trim();
        if(userName===""|| userName==null){
            userNameError.innerText="用户名不能为空";
        }else {
            var userformElt = document.getElementById("lyfrom");
            //设置表单的提交地址
            userformElt.action = "http://localhost:8080/JavaWebDemo1/loginServlet";
            //提交表单
            userformElt.sumbit();
        }
    }
}