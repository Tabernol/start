<%@ page import="model.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 04.12.2022
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Quiz</title>
</head>
<body>
   <h1>ssfg</h1>

<%--   <div>--%>
<%--       <p>Name: ${quiz.name}</p>--%>
<%--   </div>--%>
   <ul>
       <c:forEach var="user" items="${users}">
           <li><c:out value="${user}" /></li>
       </c:forEach>
   </ul>
</body>
</html>
