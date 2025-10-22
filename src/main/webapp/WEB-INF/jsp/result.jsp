<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Fortune" %>
<%
    Fortune fortune = (Fortune) request.getAttribute("fortune");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占い結果</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

    <h1>占い結果</h1>
    <p><%= fortune.getName() %> さんの <%= fortune.getToday() %> の運勢は<br><strong><%= fortune.getLuck() %></strong> です。</p>
</body>
</html>
