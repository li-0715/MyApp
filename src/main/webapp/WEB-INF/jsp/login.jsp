<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログインページ</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

    <h2>ログイン</h2>
	<hr>
    <form action="Login" method="post">
    <table>
        <tr>
            <td><label for="email">Email</label></td>
            <td><input type="text" id="email" name="email"></td>
        </tr>
        <tr>
            <td><label for="pass">パスワード</label></td>
            <td><input type="password" id="pass" name="pass"></td>
        </tr>

        	<td><input type="submit" value="ログイン"></td>

    </table>
</form>

    <c:if test="${not empty errorMsg}">
        <p>${errorMsg}</p>
    </c:if>

</body>
</html>
