<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 04.12.2022
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%= "welcome to jsp" %>
<c:out value="${'Welcome to javaTpoint'}"/>

<br>
<c:forEach var = "i" items="1,4,5,6,7,8,9">
Item <c:out value = "No. ${i}"/><p>
    </c:forEach>

</body>
</html>
