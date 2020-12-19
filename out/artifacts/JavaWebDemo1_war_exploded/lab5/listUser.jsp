<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/13
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者管理</title>
</head>
<body>
<h1>读者管理</h1>
<!--查询界面-->
<s:form action="http://localhost:8080/JavaWebDemo1/lab5/searchUser"  method="post">
    <s:textfield  name="condition" label="查询条件" size="20"/>
    <s:submit key="submit" size="10"/>
</s:form>
<table>
    <tr>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>用户角色</td>
        <td colspan="3" ><s:text name="operate"/></td>
    </tr>
    <s:iterator value="userArrayList" var="user">
        <s:if test="%{userArrayList.isEmpty}">
            <s:text name="book_search_empty"/>
        </s:if>
        <s:else>
            <tr>
                <td><s:property value="#user.name"/></td>
                <td><s:property value="#user.password"/></td>
                <td><s:property value="#user.role"/></td>
                <td>
                    <!--读者信息修改-->
                    <s:a action="lab5/getUser" >
                        <s:text name="update"/>
                        <s:param name="user.name" value="#user.name"/>
                        <s:param name="user.password" value="#user.password"/>
                        <s:param name="user.role" value="#user.role"/>
                    </s:a>
                </td>
                <td>
                    <!--删除读者信息-->
                    <s:a action="lab5/deleteUser"  onclick="javascript:return toDelete()">
                        <s:text name="delete"/>
                        <s:param name="user.name" value="#user.name"/>
                    </s:a>
                </td>
            </tr>
        </s:else>
    </s:iterator>
</table>
<a href="manageUser"><s:text name="user_search_all"/></a>
<a href="adminMain.jsp"><s:text name="to_main_page"/></a>
<hr>
<s:debug/>
</body>
</html>
