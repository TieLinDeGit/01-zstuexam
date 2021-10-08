<%@ page import="java.util.List" %>
<%@ page import="com.zstu.entity.Questions" %><%--
  Created by IntelliJ IDEA.
  User: godtie
  Date: 2021/8/2
  Time: 16:32
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
        List<Questions> questionsList =(List) request.getAttribute("questionsfind");
    %>
    <table border="2" align="center">
    <tr>
        <td>试题编号</td>
        <td>题目</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>答案</td>
        <td align="2">操作</td>
       <%
       for(Questions question:questionsList){
        %>
        <tr>
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td><a href="/zstuexam/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a></td>
        <td><a href="/zstuexam/question/updateById?questionId=<%=question.getQuestionId()%>">更新试题</a></td>
        </tr>
        <%
        }
        %>
    </table>
</center>

</body>
</html>
