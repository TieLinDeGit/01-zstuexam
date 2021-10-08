<%@ page import="com.zstu.entity.Questions" %><%--
  Created by IntelliJ IDEA.
  User: godtie
  Date: 2021/8/2
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--    Questions question =(Questions) request.getAttribute("questionById");--%>
<%--%>--%>
<center>
    <form action="/zstuexam/question/update" method="get">
        <table border="2">
            <tr>
                <td>编号</td>
                <td><input readonly type="text" name="questionId" value="${requestScope.questionById.questionId}"/></td>
            </tr>
            <tr>
                <td>题目</td>
                <td><input type="text" name="title" value="${requestScope.questionById.title}"/></td>
            </tr>
            <tr>
                <td>A</td>
                <td><input type="text" name="optionA" value="${requestScope.questionById.optionA}"/>
                </td>
            </tr>
            <tr>
                <td>B</td>
                <td><input type="text" name="optionB" value="${requestScope.questionById.optionB}"/></td>
            </tr>
            <tr>
                <td>C</td>
                <td><input type="text" name="optionC" value="${requestScope.questionById.optionC}"/></td>
            </tr>
            <tr>
                <td>D</td>
                <td><input type="text" name="optionD" value="${requestScope.questionById.optionD}"/></td>
            </tr>
            <tr>
                <td>答案</td>
                <td><input type="text" name="answer" value="${requestScope.questionById.answer}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="更新"/></td>
                <td><input type="reset"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
