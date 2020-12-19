<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书添加页面</title>
<%--    <link href="http://localhost:8080/JavaWebDemo1/lab3/source/css/login.css" type="text/css" rel="stylesheet"/>--%>
    <script type="text/javascript" src="../js/addBookConfirm.js"></script>
</head>
<body>
    <h4><s:text name="add_book"/></h4>
        <s:form action="http://localhost:8080/JavaWebDemo1/lab5/addBook" enctype="multipart/form-data" method="post">
            <s:textfield  name="book.isbn" key="book.isbn" size="20"/><br>
            <s:textfield  name="book.title" key="book.title" size="20"/><br>
            <s:textfield  name="book.price" key="book.price" size="20"/><br>
            <s:file name="file" key="uploadBookBriefFile"/>
            <s:textfield  name="book.author.name" key="book.author.name" size="20"/><br>
            <s:textfield  name="book.author.tel" key="book.author.tel" size="20"/><br>
            <s:textfield  name="book.author.email" key="book.author.email" size="20"/><br>
            <s:submit key="submit" size="10"/>
            <s:reset key="reset" size="10"/>
        </s:form>
    <a href="adminMain.jsp"><s:text name="to_main_page"/></a>
<hr><s:actionmessage/>
<hr><s:debug/>
</body>
</html>
