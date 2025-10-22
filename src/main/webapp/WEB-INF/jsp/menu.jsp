<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>

<nav>
    <a href="/MyApp/index.jsp">トップ</a>

    <c:if test="${not empty sessionScope.loginUser}">
        <a href="ListServlet">商品</a>
        <a href="CartAddServlet">カート</a>
        <a href="Login">マイページ</a>
        <a href="Logout">ログアウト</a>
    </c:if>

    <c:if test="${empty sessionScope.loginUser}">
        <a href="Login">ログイン</a>
        <a href="RegisterUser">ユーザー登録</a>
    </c:if>
</nav>
<hr>

</body>
</html>
