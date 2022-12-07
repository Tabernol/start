<%@ page import="services.UserService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

<h1>Hello user!</h1>
<c:out value="${requestScope.}"/>
<br>

<%--<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"--%>
<%--                   url = "jdbc:mysql://127.0.0.1:3306/epam_project_testing"--%>
<%--                   user = "root"  password = "root"/>--%>

<%--<sql:query dataSource = "${snapshot}" var = "result">--%>
<%--    SELECT * from user where id_user =;--%>
<%--</sql:query>--%>


<br>

<a href="<c:url value="/logout"/>">Logout</a>
<h1></h1>
<a href="<c:url value='/info' />">Info User</a>
</body>
</html>