<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.testee0.domain.Product" %>
<%@ page import="java.util.List" %>

<html>
<head>
  <title>Товары</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<h2>Список товаров</h2>
<table>
  <tr>
    <th>Наименование</th>
    <th>Размер</th>
    <th>Вес (кг)</th>
  </tr>
  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product product : products) {
  %>
  <tr>
    <td><%= product.getName() %></td>
    <td><%= product.getSize() %></td>
    <td><%= product.getWeight() %></td>
  </tr>
  <% } %>
</table>
<a href="index.jsp">На главную</a>
</body>
</html>

