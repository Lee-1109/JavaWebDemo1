<%@ page import="model.User" %>
<%@ page import="model.Book" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myUser" class="model.User"/>
<jsp:useBean id="myBook" class="model.Book"/>
<html>
<head>
    <title>添加成功通知页</title>
    <link href="../source/css/login.css" type="text/css" rel="stylesheet">
</head>

<body>

    <h1>你好，您已成功添加《<%=myBook.getTitle()%>》<br> 价格：<%=myBook.getPrice()%></h1>
    <a href="addBook.jsp">点我返回继续添加图书</a>
</body>
</html>
