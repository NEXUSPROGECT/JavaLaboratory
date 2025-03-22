<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.testee0.domain.Manufacturer" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Производители</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
<h2>Список производителей</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Страна</th>
        <th>Контактное лицо</th>
        <th>Телефон</th>
        <th></th>
    </tr>
    <%
        List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
        for (Manufacturer manufacturer : manufacturers) {
    %>
    <tr>
        <td><%= manufacturer.getId() %></td>
        <td><%= manufacturer.getName() %></td>
        <td><%= manufacturer.getCountry() %></td>
        <td><%= manufacturer.getContactPerson() %></td>
        <td><%= manufacturer.getPhone()%></td>
        <td><a href="<%= request.getContextPath() %>/manufacturersEdit?id=<%= manufacturer.getId() %>">Редактировать</a></td>

    </tr>
    <% } %>
</table>
<a href="manufacturersAdd">Добавить</a>
<a href="index.jsp">На главную</a>
</body>
</html>

