<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>マイページ</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<c:if test="${not empty sessionScope.loginUser}">
    <h1>${sessionScope.loginUser.name} さんのマイページ</h1>
    <p><a href="UranaiServlet">今日の運勢</a></p>
</c:if>

</body>
</html>
