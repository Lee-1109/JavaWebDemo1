<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="systemName"/></title>
</head>
<body>
    <hr>
    <h3><s:property value="#session.nowUser.name"/>
        <s:property value="#session.nowUser.role"/>
        <a href="userLogout">【注销登陆】</a></h3>
    <hr>
        <a href="addUser.jsp">1.<s:text name="add_user"/></a><br>
        <a href="manageUser">2.<s:text name="manage_user"/></a><br>
        <a href="addBook.jsp">3.<s:text name="book_add"/></a><br>
        <a href="allBook">4.<s:text name="book_browser"/></a>
<s:debug/>
</body>
</html>
