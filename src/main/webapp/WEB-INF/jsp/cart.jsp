<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>カート</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<c:choose>
    <c:when test="${empty sessionScope.cartlist}">
        <p>カートに商品はありません</p>
    </c:when>
    <c:otherwise>
        <p>${fn:length(sessionScope.cartlist)}種類の商品があります</p>
        <table border="1">
            <c:forEach var="c" items="${sessionScope.cartlist}">
                <tr>
                    <td>${c.goods.goodsName}</td>
                    <td>${c.goods.price}円</td>
                    <td><img src="assets/img/${c.goods.image}" width="100"></td>
                    <td>${c.num}個</td>
                    <td>
                        <form action="CartDeleteServlet" method="get">
                            <input type="hidden" name="id" value="${c.goods.id}">
                            <button type="submit">カートから削除</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>
