<%--
  Created by IntelliJ IDEA.
  User: Vusez
  Date: 06.02.2025
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.testee0.Person" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>
<h2>Сотрудники</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Телефон</th>
        <th>Email</th>
        <th>Должность</th>
    </tr>
    <%
        // Получаем атрибут из request
        List<Person> people = (List<Person>) request.getAttribute("people");

        if (people != null && !people.isEmpty()) {
            for (Person person : people) {
    %>
    <tr>
        <td><%= person.getId() %></td>
        <td><%= person.getFirstName() %></td>
        <td><%= person.getLastName() %></td>
        <td><%= person.getPhone() %></td>
        <td><%= person.getEmail() %></td>
        <td><%= person.getRole() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="6">Нет данных для отображения.</td></tr>
    <%
        }
    %>
</table>
</body>
</html>