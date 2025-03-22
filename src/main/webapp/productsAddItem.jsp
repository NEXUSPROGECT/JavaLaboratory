<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить продукт</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<div class="container">
    <h2>Добавить продукт</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/productsAdd" method="post">
        <label for="name">Название:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="size">Размер:</label>
        <input type="text" id="size" name="size" required><br><br>

        <label for="weight">Вес:</label>
        <input type="number" id="weight" name="weight" required><br><br>

        <button type="submit" style="
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        ">Добавить</button>
    </form>

    <br>
    <a href="products">Назад к списку продуктов</a>
</div>
</body>
</html>