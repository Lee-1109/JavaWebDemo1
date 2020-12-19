<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/13
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者信息修改</title>
</head>
<body>
<h1>读者信息修改页面</h1>
<table>
    <s:form action="http://localhost:8080/JavaWebDemo1/lab5/updateUser" method="post">
        <tr>
            <td><s:textfield  name="user.name"   key="user.name"  size="20" readonly="true"/></td>
        </tr>
        <tr>
            <td><s:textfield  name="user.password"  key="user.password"  size="20"/></td>
        </tr>
        <tr>
            <td><s:textfield  name="user.role"  key="user.role"  size="20" readonly="true"/></td>
        </tr>
        <tr>
            <s:submit key="submit" size="10" action="updateUser" method="updateUser"/>
        </tr>
    </s:form>
</table>
<hr>
<s:if test="hasActionMessages()">
    <s:actionmessage/>
</s:if>
<hr>
<a href="adminMain.jsp"><s:text name="to_main_page"/></a>
</body>
</html>
