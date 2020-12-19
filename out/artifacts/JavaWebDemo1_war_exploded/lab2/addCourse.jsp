<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/20
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myCourse" class="model.Course"/>
<html>
<head>
    <title>添加课程信息</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/addcourse" method="post">
        课名：<input type="text" name="name" size="20"><br>
        学分：<input type="text" name="credit" size="20"><br>
        学时：<input type="text" name="period" size="20"><br>
        考核：
        <label><input type="radio" name="assessment" size="20"  value="0" checked="checked">考察</label>
        <label><input type="radio" name="assessment" value="1">考核</label>
        <br>
        学期：
        <select name="term">
            <option value="1">一</option>
            <option value="2">二</option>
            <option value="3">三</option>
            <option value="4">四</option>
            <option value="5">五</option>
            <option value="6">六</option>
        </select><br>
        简介：<textarea cols="20" rows="2" name="brief" value="请输入课程简介">
    </textarea><br>
        <input type="submit" value="提交" size="10">
        <input type="reset" value="重置" size="10">
    </form>
</body>
</html>
