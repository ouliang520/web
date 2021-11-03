<%--
  Created by IntelliJ IDEA.
  User: celestial
  Date: 2021/11/3
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%String result = (String) request.getAttribute("info");%>
</head>
<body>
<center>
    <font style="color: red;font-size: 40px"><%=result%>
    </font><br>
    <a href="question_add.html">返回首页</a>
</center>
</body>
</html>
