<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/15
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书</title>
</head>
<body>
<table>
    <tr>
        <td><s:text name="book.isbn"/></td>
        <td><s:text name="book.title"/></td>
        <td><s:text name="book.price"/></td>
        <td><s:text name="book.author.name"/></td>
        <td colspan="3" ><s:text name="operate"/></td>
    </tr>
    <s:iterator value="books" var="book">
        <s:if test="%{books.isEmpty}">
            <s:text name="book_search_empty"/>
        </s:if>
        <s:else>
            <tr>
                <td><s:property value="#book.isbn"/></td>
                <td><s:property value="#book.title"/></td>
                <td><s:property value="#book.price"/></td>
                <td><s:property value="#book.author.name"/></td>
                <td>
                    <!--借书-->
                    <s:a action="lab5/borrowBook" >
                        <s:text name="borrow_book"/>
                        <s:param name="book.isbn" value="#book.isbn"/>
                        <s:param name="user.name" value="#session.nowUser.name"/>
                    </s:a>
                </td>
            </tr>
        </s:else>
    </s:iterator>
</table>
<a href="readerMain.jsp"><s:text name="to_main_page"/></a>
</body>
</html>
