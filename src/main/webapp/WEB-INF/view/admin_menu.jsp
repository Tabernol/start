<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h1>Hello ADMIN!</h1>
<a href="<c:url value='/logout' />">Logout</a>
<h1></h1>
<a href="<c:url value='/info' />">Info User</a>
<p></p>

<form method="post" action="<c:url value='/del' />">
    <input type="text" required placeholder="login" name="login"><br>
    <input class="button" type="submit" value="Delete User">
</form>
<%--<a href="<c:url value='/del' />"> Delete User</a>--%>
</body>
</html>