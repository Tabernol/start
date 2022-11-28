<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<div class="form">

    <h1>Enter to ...</h1><br>
    <form method="post" action="">

        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="submit">

    </form>
</div>

<a href="<c:url value='/registration' />">Registration</a>
</body>
</html>
