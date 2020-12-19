<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>图书馆登录系统</title>
    <link href="lab3/source/css/login.css" type="text/css" rel="stylesheet">
    <script src="lab3/js/login.js" type="text/javascript"></script>
</head>
<body>
        <img src="lab3/source/img/login.png" width="1494" height="256" alt="南昌航空大学图书馆"/>
    <div class="myArea">
        <form action="loginServlet"  name="myForm"  method="post">
            <label>姓名：<input type="text" name="name" class="myInput" id="username"/></label><br>
            <label>密码：<input type="password" name="password" class="myInput"/></label><br>
            <input type="submit" value="提交" class="myButton">
            <input type="reset" value="重置" class="myButton">
        </form>
    </div>
</body>
</html>
