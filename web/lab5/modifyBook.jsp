<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/11/10
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="please_modify"/></title>
</head>
<body>
<h1><s:text name="please_modify"/></h1>
<s:form action="http://localhost:8080/JavaWebDemo1/lab5/modifyBook" method="post">
    <s:textfield  name="book.isbn"   key="book.isbn"  size="20" readonly="true" /><br>
    <s:textfield  name="book.title"  key="book.title"  size="20"/><br>
    <s:textfield  name="book.price"  key="book.price"  size="20"/><br>
    <s:textfield  name="book.author.id" key="book.author.id"  size="20"/><br>
    <s:textfield  name="book.author.name" key="book.author.name"  size="20"/><br>
    <s:textfield  name="book.author.tel" key="book.author.tel"  size="20"/><br>
    <s:textfield  name="book.author.email" key="book.author.email"  size="20"/><br>
    <s:property value="book.bookInformation" /><br>
    <s:submit key="submit" size="10" action="modifyBook" method="modify"/>
    <s:reset key="reset" size="10"/>
</s:form>
<s:if test="hasActionMessages()">
        <s:actionmessage/>
</s:if>
<hr>
<s:debug/>
</body>
</html>
