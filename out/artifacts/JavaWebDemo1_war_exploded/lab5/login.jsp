<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title><s:text name="systemName"/></title>
</head>
<body>
        <div class="login">
            <s:form action="http://localhost:8080/JavaWebDemo1/lab5/userLogin"  method="post">
                <s:textfield name="user.name"  key="user.name" size="20" palceholder="请输入密码"/><br>
                <s:password  name="user.password"  key="user.password" size="21" placeholder="请输入密码"/><br>
                <s:submit key="submit"/>
                <s:reset  key="reset"/>
            </s:form>
        </div>
</body>
<s:debug/>
</html>
