<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>24jz0104 | カートに追加</title>
    
</head>
<body>

<jsp:include page="menu.jsp" />

<div class="center">
    <h2>カートに追加</h2>

    <form action="CartAddServlet" method="post">
        <table>
            <tr>
                <td rowspan="5">
                    <img src="assets/img/${goods.image}" alt="${goods.goodsName}" width="200">
                </td>
                <th>商品コード</th>
                <td>${goods.goodsCode}</td>
            </tr>
            <tr>
                <th>商品名</th>
                <td>${goods.goodsName}</td>
            </tr>
            <tr>
                <th>商品単価</th>
                <td>${goods.price} 円</td>
            </tr>
            <tr>
                <th>購入数量</th>
                <td>
                    <select name="num">
                        <c:forEach begin="1" end="${goods.stock}" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="center">
                    <input type="hidden" name="id" value="${goods.id}">
                    <button type="submit">カートに追加</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
