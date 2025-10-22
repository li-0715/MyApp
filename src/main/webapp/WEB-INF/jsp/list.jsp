<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0104 | 商品一覧</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<p>検索キーワードを入力してください。</p>
<form action="ListServlet" method="post">
    <input type="text" name="keyword" />
    <input type="submit" value="検索" />
</form>

<hr>

<c:if test="${not empty goodsList}">
    <table border="1">
        <tr>
            <th>商品コード</th>
            <th>商品名</th>
            <th>単価</th>
            <th>在庫数</th>
            <th>画像</th>
            <th>操作</th> <!-- カート追加用の列 -->
        </tr>
        <c:forEach var="g" items="${goodsList}">
            <tr>
                <td>${g.goodsCode}</td>
                <td>${g.goodsName}</td>
                <td>${g.price}円</td>
                <td>${g.stock}</td>
                <td><img src="assets/img/${g.image}" alt="${g.goodsName}" width="100" /></td>
                <td>
                    <a href="CartAddServlet?id=${g.id}">
                        <button type="button">カートに追加</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty goodsList}">
    <p>商品がありません</p>
</c:if>

</body>
</html>
