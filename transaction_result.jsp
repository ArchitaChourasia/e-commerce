<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transaction Result</title>
</head>
<body>
    <h1>Transaction Result</h1>
    <% if ((Boolean) request.getAttribute("transactionResult")) { %>
        <p>Transaction Successful!</p>
    <% } else { %>
        <p>Transaction Failed!</p>
    <% } %>
</body>
</html>
