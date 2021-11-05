<%@ page import="com.exam.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: celestial
  Date: 2021/11/4
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>题目查询</title>
</head>
<body>
<table border="2" align="center">
    <tr>
        <td>题目信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>正确答案</td>
        <td>操作</td>
    </tr>
    <%
        List<Question> list = (List<Question>) request.getAttribute("question");

        //在后续中,JSTL有效你不EL不能遍历集合输出问题
        int i = 0;
        for (Question question : list
        ) {
            i += 1;
            if (i % 2 == 0) {
    %>
    <tr style="background:yellow">
            <%
            }else{
                %>
    <tr style="background:palegreen">
        <% }
        %>
        <td><%=question.getTitle()%>
        </td>
        <td><%=question.getOptionA()%>></td>
        <td><%=question.getOptionB()%>
        </td>
        <td><%=question.getOptionC()%>
        </td>
        <td><%=question.getOptionD()%>
        </td>
        <td><%=question.getAnswer()%>
        </td>
        <td><a href="questiondelete?title=<%=question.getTitle()%>">删除试题</a> </td>
    </tr>
    <% } %>
</table>
</body>
</html>
