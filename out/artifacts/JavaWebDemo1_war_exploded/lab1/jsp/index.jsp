<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>输入信息</title>
    <link href="../css/base.css" type="text/css" rel="stylesheet">
  </head>
  <body>
  <h1>货物信息添加界面</h1>
    <form action="record.jsp" method="post">
      name:<input type="text" name="name" size="20" ><br>
      price:<input type="text" name="price" size="20"><br>
      quantity:<input type="text" name="quantity" size="20"><br>
      <input type="submit" value="提交" size="10">
      <input type="reset" value="重置" size="10">
    </form>
  </body>
</html>
