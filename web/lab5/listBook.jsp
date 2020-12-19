<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/11/8
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>浏览书籍</title>
    <script type="text/javascript" src="../js/deleteConfirm.js"></script>
</head>
<body>
<!--查询界面-->
        <s:form action="http://localhost:8080/JavaWebDemo1/lab5/searchBook"  method="post">
            <s:textfield  name="condition" label="查询条件" size="20"/>
            <s:submit key="submit" size="10"/>
        </s:form>
<!--结果显示界面-->
<table>
    <tr>
        <td><s:text name="book.isbn"/></td>
        <td><s:text name="book.title"/></td>
        <td><s:text name="book.price"/></td>
        <td>作者ID</td>
        <td><s:text name="book.author.name"/></td>
        <td>作者电话</td>
        <td>作者邮箱</td>
        <td colspan="3" ><s:text name="operate"/></td>
    </tr>
    <s:iterator value="bookArrayList" var="book">
        <s:if test="%{bookArrayList.isEmpty}">
             <s:text name="book_search_empty"/>
        </s:if>
        <s:else>
            <tr>
                <td><s:property value="#book.isbn"/></td>
                <td><s:property value="#book.title"/></td>
                <td><s:property value="#book.price"/></td>
                <td><s:property value="#book.author.id"/></td>
                <td><s:property value="#book.author.name"/></td>
                <td><s:property value="#book.author.tel"/></td>
                <td><s:property value="#book.author.email"/></td>
                <td>
                    <!--图书简介-->
                    <s:a action="lab5/informationBook">
                        <s:text name="brief"/>
                        <s:param name="book.isbn" value="#book.isbn"/>
                        <s:param name="book.title" value="#book.title"/>
                        <s:param name="book.price" value="#book.price"/>
                        <s:param name="book.author.name" value="#book.author.name"/>
                        <s:param name="book.author.tel" value="#book.author.tel"/>
                        <s:param name="book.author.email" value="#book.author.email"/>
                        <s:param name="book.bookInformation" value="#book.bookInformation"/>
                    </s:a>
                </td>
                <td>
                    <!--图书信息修改-->
                    <s:a action="lab5/getBook" >
                        <s:text name="update"/>
                        <s:param name="book.isbn" value="#book.isbn"/>
                        <s:param name="book.title" value="#book.title"/>
                        <s:param name="book.price" value="#book.price"/>
                        <s:param name="book.author.id" value="#book.author.id"/>
                        <s:param name="book.author.name" value="#book.author.name"/>
                        <s:param name="book.author.tel" value="#book.author.tel"/>
                        <s:param name="book.author.email" value="#book.author.email"/>
                        <s:param name="book.bookInformation" value="#book.bookInformation"/>
                    </s:a>
                </td>
                <td>
                    <!--删除图书信息-->
                    <s:a action="lab5/deleteBook"  onclick="javascript:return toDelete()">
                        <s:text name="delete"/>
                        <s:param name="book.isbn" value="#book.isbn"/>
                    </s:a>
                </td>
            </tr>
        </s:else>
    </s:iterator>
</table>
    <a href="allBook"><s:text name="book_search_all"/></a>
    <a href="adminMain.jsp"><s:text name="to_main_page"/></a>
<hr>
<s:debug/>
</body>
</html>
