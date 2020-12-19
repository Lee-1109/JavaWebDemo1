<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/25
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询图书</title>
    <link href="../source/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
    <h1>查询图书界面</h1>
        <form action="<%=request.getContextPath()%>/myFindBook" method="post" >
            <table align="center">
                <tr>
                    <td>书名：</td>
                    <td> <input type="text" name="title" size="20"></td>
                </tr>
                <br>
            </table>
            <input type="submit" value="提交" size="10"></td>
            <input type="reset" value="重置" size="10"></td>
        </form>
        <a href="../main.jsp">返回主页</a>
</body>
</html>
