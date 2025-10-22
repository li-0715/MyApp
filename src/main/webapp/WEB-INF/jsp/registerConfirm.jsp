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

<p>下記のユーザーを登録します</p>
<p>
Email: ${registerUser.email} <br>
名前: ${registerUser.name} <br>
</p>

<a href="RegisterUser">戻る</a>
<a href="RegisterUser?action=done">登録</a>

</body>
</html>
