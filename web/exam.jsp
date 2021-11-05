<%@ page import="java.util.List" %>
<%@ page import="com.exam.entity.Question" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: celestial
  Date: 2021/11/5
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="over">
        <table border="2" >
            <tr align="center" style="background: palegreen">
                <td>题目编号</td>
                <td>题目信息</td>
                <td>A</td>
                <td>B</td>
                <td>C</td>
                <td>D</td>
<%--                <td>你的答案</td>--%>
            </tr>
            <%
                List<String> list =new ArrayList();
                int i =1;
                List<Question> questionList = (List<Question>) request.getAttribute("questionlist");
                for (Question question : questionList
                ) {
            %>
            <tr align="center">
                <td><%=i%></td>
                <td ><%=question.getTitle()%></td>
                <td><%=question.getOptionA()%></td>
                <td><%=question.getOptionB()%></td>
                <td><%=question.getOptionC()%></td>
                <td><%=question.getOptionD()%></td>
            </tr>
            <tr align="center" style="background: aqua">
                <td colspan="2">题目<%=i%>的答案是</td>
                <td><input type="radio" name="answer<%=i%>" value="A"></td>
                <td><input type="radio" name="answer<%=i%>" value="B"></td>
                <td><input type="radio" name="answer<%=i%>" value="C"></td>
                <td><input type="radio" name="answer<%=i%>" value="D"></td>
            </tr>
            <%      list.add(question.getTitle());
                    i++;}
                request.getSession().setAttribute("title",list);
            %>
            <tr align="center">
                <td colspan="4"><input type="submit" value="提交答案"></td>
                <td colspan="2"><input type="reset" value="重做"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
