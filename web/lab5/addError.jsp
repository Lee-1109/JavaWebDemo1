<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/29
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="error_book_exist"/></title>
    <link href="http://localhost:8080/JavaWebDemo1/lab3/source/css/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>

    <h1><s:text name="error_book_exist"/></h1>
    <h1><s:property value="book.title"/></h1>
    <h1><s:property value="book.price"/></h1>
<s:debug></s:debug>
</body>
</html>
