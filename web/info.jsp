<%--
  Created by IntelliJ IDEA.
  User: godtie
  Date: 2021/8/2
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
         String result = (String)request.getAttribute("key");
    %>
    <font style="color: red;font-size: 30px">
        <%=result%>
    </font>
</center>

</body>
</html>
