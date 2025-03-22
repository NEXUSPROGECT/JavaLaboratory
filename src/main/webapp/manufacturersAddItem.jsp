<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить производителя</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<div class="container">
    <h2>Добавить производителя</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/manufacturersAdd" method="post">
        <label for="name">Название:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="country">Страна:</label>
        <input type="text" id="country" name="country" required><br><br>

        <label for="contactPerson">Контактное лицо:</label>
        <input type="text" id="contactPerson" name="contactPerson" required><br><br>

        <label for="phone">Телефон:</label>
        <input type="text" id="phone" name="phone" required><br><br>

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
    <a href="manufacturers">Назад к списку производителей</a>
</div>
</body>
</html>