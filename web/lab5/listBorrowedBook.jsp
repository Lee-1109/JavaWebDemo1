<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/15
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已借阅图书</title>
</head>
<body>
<table>
    <tr>
        <td><s:text name="book.isbn"/></td>
        <td>借阅人</td>
        <td>借阅时间</td>
        <td colspan="3" ><s:text name="operate"/></td>
    </tr>
    <s:iterator value="lends" var="lend">
        <s:if test="%{lends.isEmpty}">
            <s:text name="book_search_empty"/>
        </s:if>
        <s:else>
            <tr>
                <td><s:property value="#lend.lendPK.bookIsbn"/></td>
                <td><s:property value="#lend.lendPK.userName"/></td>
                <td><s:property value="#lend.date"/></td>
                <td>
                    <!--还书-->
                    <s:a action="lab5/returnBook">
                        <s:text name="return_book"/>
                        <s:param name="user.name" value="#lend.lendPK.userName"/>
                        <s:param name="book.isbn" value="#lend.lendPK.bookIsbn"/>
                    </s:a>
                </td>
            </tr>
        </s:else>
    </s:iterator>
</table>
<a href="readerMain.jsp"><s:text name="to_main_page"/></a>
<hr><s:actionmessage/>
<hr><s:debug/>
</body>
</html>
