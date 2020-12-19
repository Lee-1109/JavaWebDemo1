<%@ page import="model.Course" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/10/22
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="myCourse" class="model.Course"/>
<html>
<head>
    <title>通知页：添加课程信息成功!</title>
</head>
<body>
    <h1>添加课程信息成功!</h1>
    <%
        myCourse=(Course) session.getAttribute("myCourse");

    %>
    <h3>课程名：<%out.print(myCourse.getName());%></h3>
    <h3>学分：<%out.print(myCourse.getCredit());%></h3>
    <h3>学时：<%out.print(myCourse.getPeriod());%></h3>
    <h3>考核方式：<%
        if(myCourse.getAssessment()==0){
            out.print("考察");
        }else {
            out.print("考核");
        }

    %></h3>
    <a href="addCourse.jsp">点我返回继续添加课程</a>
</body>
</html>
