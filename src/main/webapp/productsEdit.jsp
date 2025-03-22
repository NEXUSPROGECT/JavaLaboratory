<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.testee0.domain.Product" %>
<html>
<head>
    <title>Редактировать производителя</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<div class="container">
    <h2>Редактировать производителя</h2>
    <% Product product = (Product) request.getAttribute("product"); %>
    <form action="<%= request.getContextPath() %>/productsEdit" method="post">
        <input type="hidden" name="id" value="<%= product.getId() %>">

        <label for="name">Название:</label>
        <input type="text" id="name" name="name" value="<%= product.getName() %>" required><br><br>

        <label for="size">Размер:</label>
        <input type="text" id="size" name="size" value="<%= product.getSize() %>" required><br><br>

        <label for="weight">Вес:</label>
        <input type="number" id="weight" name="weight" value="<%= product.getWeight() %>" required><br><br>

        <button type="submit">Сохранить</button>
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/products">Назад к списку</a>
</div>
</body>
</html>