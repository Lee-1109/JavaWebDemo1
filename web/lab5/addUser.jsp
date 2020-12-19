<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/13
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加读者页面</title>
</head>
<body>
<h4><s:text name="add_user"/></h4>
<s:form action="http://localhost:8080/JavaWebDemo1/lab5/addUser"  method="post">
    <s:textfield  name="user.name" key="user.name" size="20"/><br>
    <s:textfield  name="user.password" key="user.password" size="20"/><br>
    <s:textfield  name="user.role" key="user.role" size="20"/><br>
    <s:submit key="submit" size="10"/>
    <s:reset key="reset" size="10"/>
</s:form>
<a href="adminMain.jsp"> <s:text name="to_main_page"/> </a>
<hr><s:actionmessage/>
<hr><s:debug/>
</body>
</html>
