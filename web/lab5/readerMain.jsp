<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/13
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者首页</title>
</head>
<body>
<hr>
    <h3><s:text name="nowUser"/><s:property value="#session.nowUser.name"/>
        <s:property value="#session.nowUser.role"/>
        <a href="userLogout">【注销登陆】</a></h3>
    <hr>
<!--已借图书-->
    <s:a action="lab5/listBorrowed" >
        <s:text name="borrowed_book"/>
        <s:param name="user.name" value="#session.nowUser.name"/>
    </s:a>
<%--    <a href="listBorrowed">1.<s:text name="borrowed_book"/></a><br>--%>
<!--未借图书-->
    <a href="listBorrowBook">2.<s:text name="browser_book"/></a>
    <s:debug/>
</body>
</html>
