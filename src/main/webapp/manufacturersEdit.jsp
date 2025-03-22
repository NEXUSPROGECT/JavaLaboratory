<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.testee0.domain.Manufacturer" %>
<html>
<head>
    <title>Редактировать производителя</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<div class="container">
    <h2>Редактировать производителя</h2>
    <% Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer"); %>
    <form action="<%= request.getContextPath() %>/manufacturersEdit" method="post">
        <input type="hidden" name="id" value="<%= manufacturer.getId() %>">

        <label for="name">Название:</label>
        <input type="text" id="name" name="name" value="<%= manufacturer.getName() %>" required><br><br>

        <label for="country">Страна:</label>
        <input type="text" id="country" name="country" value="<%= manufacturer.getCountry() %>" required><br><br>

        <label for="contactPerson">Контактное лицо:</label>
        <input type="text" id="contactPerson" name="contactPerson" value="<%= manufacturer.getContactPerson() %>" required><br><br>

        <label for="phone">Телефон:</label>
        <input type="text" id="phone" name="phone" value="<%= manufacturer.getPhone() %>" required><br><br>

        <button type="submit">Сохранить</button>
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/manufacturers">Назад к списку</a>
</div>
</body>
</html>

