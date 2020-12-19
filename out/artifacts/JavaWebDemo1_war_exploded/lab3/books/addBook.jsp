<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myUser" class="model.User"/>
<html>
<head>
    <title>添加图书</title>
    <link href="../source/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
    <%
        myUser= (User) session.getAttribute("user");
    %>
    <h1>管理员<%=myUser.getName()%>,你好，请您输入将要添加的图书信息！</h1>
    <form action="<%=request.getContextPath()%>/addBookServlet" method="post">
            <label>图书名:</label><input type="text" name="title" size="20"><br>
            <label>价格：</label><input type="text" name="price" size="20"><br>
            <input type="submit" value="提交" size="10">
            <input type="reset" value="重置" size="10">
    </form>
    <a href="../main.jsp">返回主页</a>
</body>
</html>
