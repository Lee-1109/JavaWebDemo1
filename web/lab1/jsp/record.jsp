<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/19
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myDB" class="dao.impl.GoodsDAO"></jsp:useBean>
<html>
<head>
    <title>展示信息</title>
    <link href="../css/base.css" type="text/css" rel="stylesheet">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name").trim();
        double price=Double.parseDouble(request.getParameter("price"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        myDB.getConnection();
        ResultSet rs= myDB.executeQueryAll("goods");
    %>
    <h2>插入数据前数据库中查询结果如下:</h2>
        <table align="center">
            <tr>
                <th><%out.print("货物名：");%></th>
                <th><%out.print("价格");%></th>
                <th><%out.print("数量");%></th>
            </tr>
        <%
            while (rs.next()) {
        %>
            <tr>
                <td><%out.print(rs.getString(1));%></td>
                <td><%out.print(rs.getString(2));%></td>
                <td><%out.print(rs.getString(3));%></td>
            </tr>
        <%
            }
            rs.close();
        %>
    </table>

    <br>
    <br>
        <%
            myDB.executeInsert("goods",name,price,quantity);
        %>
        <h2>插入数据后数据库中查询结果如下:</h2>
        <table align="center">
            <tr>
                <th><%out.print("货物名：");%></th>
                <th><%out.print("价格");%></th>
                <th><%out.print("数量");%></th>
            </tr>

        <%
            
            rs= myDB.executeQueryAll("goods");
            while (rs.next()) {
        %>
            <tr>
                <td><%out.print(rs.getString(1));%></td>
                <td><%out.print(rs.getString(2));%></td>
                <td><%out.print(rs.getString(3));%></td>
            </tr>
        <%
            }
            myDB.closeConnection();
        %>
    </table>
        <article>
        <h1>您所输入的信息如下：</h1><br>
        name:<%=name%><br>
        price:<%=price%><br>
        quantity:<%=quantity%>
        </article>
</body>
</html>
