<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myUser" class="model.User"/>
<html>
<head>
    <title>图书管理主界面</title>
    <link href="source/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
    <%myUser= (User) session.getAttribute("user");%>
    <img src="source/img/login.png" alt="南昌航空大学图书馆" width="1494">
        <hr>
    <h1 class="welcome">你好!<%=myUser.getName()%>  欢迎登陆图书管理系统</h1>
    <hr>
        <a href="books/addBook.jsp">1.点我添加图书</a>
        <a href="books/findBook.jsp">2.点我查询图书</a>
</body>
</html>
