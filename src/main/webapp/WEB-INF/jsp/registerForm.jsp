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

<c:if test="${not empty msg}">
  <p style="color: red;">${msg}</p>
</c:if>

<form action="RegisterUser" method="post">
Email:<input type="text" name="id"><br>
パスワード:<input type="password" name="pass"><br>
名前:<input type="text" name="name"><br>
<input type="submit" value="確認">
</form>

</body>
</html>
