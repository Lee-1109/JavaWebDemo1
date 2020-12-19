<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Book" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myBook" class="model.Book"/>
<jsp:useBean id="myUser" class="model.User"/>
<html>
<head>
    <title>书籍查找成功通知</title>
    <link href="../source/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
    <%myUser=(User) session.getAttribute("user");%>
    <h1 align="center"><%=myUser.getName()%>,书籍查找成功！</h1>
    <table width="300" align="center">
        <tr>
            <td>图书名</td>
            <td>图书价格</td>
        </tr>
    <%
        ArrayList<Book> bookList=(ArrayList<Book>) session.getAttribute("result");
        Iterator iterator=bookList.iterator();
        while(iterator.hasNext())
        {
            myBook= (Book) iterator.next();
    %>

        <tr>
            <td><%=myBook.getTitle()%></td>
            <td><%=myBook.getPrice()%></td>
        </tr>
    <%
        }
    %>
    </table>
    <a href="../main.jsp">1.点击我返回首页</a><br>
    <a href="findBook.jsp">2.点我继续查询图书</a>
</body>
</html>
