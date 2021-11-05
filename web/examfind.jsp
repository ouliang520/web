<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.exam.dao.exam" %><%--
  Created by IntelliJ IDEA.
  User: celestial
  Date: 2021/11/5
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩查询</title>
</head>
<body>
    <center>
        <table border="2" align="center">

            <tr align="center">
                <td>姓名</td>
                <td>成绩</td>
                <td>考试时间</td>
            </tr>
            <%
                List<exam> list =new ArrayList<>();
                list= (List<exam>) request.getAttribute("exam");
                for (exam exam:list
                     ) {
            %>
            <tr align="center">
                <td><%=exam.getName()%></td>
                <td><%=exam.getGrades()%></td>
                <td><%=exam.getTime()%></td>
            </tr>

            <%
                }
            %>
        </table>
    </center>
</body>
</html>
