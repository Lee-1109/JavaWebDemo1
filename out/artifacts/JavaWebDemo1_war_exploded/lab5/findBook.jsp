<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/27
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>寻找书籍</title>
    <link href="http://localhost:8080/JavaWebDemo1/css/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<h1>查询图书界面</h1>
    <div class="login">
        <s:form action="http://localhost:8080/JavaWebDemo1/lab5/searchBook"  method="post">
            <s:textfield  name="condition" label="查询条件" size="20"/>
            <s:submit key="submit" size="10"/>
            <s:reset key="reset" size="10"/>
        </s:form>
    </div>

<s:a action="allBook"><s:text name="search_all_book"/></s:a><br>
<s:a href="main.jsp"><s:text name="to_main_page"/></s:a>
</body>
</html>
