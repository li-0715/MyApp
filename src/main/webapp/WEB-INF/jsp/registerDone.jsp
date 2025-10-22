<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0104</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<h1>ユーザー登録</h1>

<c:if test="${empty registerUser}">
    <p>登録完了しました</p>
</c:if>

<c:if test="${not empty registerUser}">
    <p>登録できませんでした</p>
    <c:remove var="registerUser" scope="session" />
</c:if>

</body>
</html>
