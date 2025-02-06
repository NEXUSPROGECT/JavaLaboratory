<%--
  Created by IntelliJ IDEA.
  User: Vusez
  Date: 06.02.2025
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.testee0.domain.FinAsset" %>
<%@ page import="com.example.testee0.domain.Bond" %>
<%@ page import="com.example.testee0.domain.Security" %>

<html>
<head>
    <title>Финансовые инструменты</title>
</head>
<body>
<h2>Список финансовых инструментов</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Тикер</th>
        <th>Биржевая площадка</th>
        <th>Орган регистрации</th>
        <th>Дата регистрации</th>
        <th>Эмитент</th>
        <th>Форма выпуска</th>
        <th>Номинал</th>
        <th>Количество</th>
    </tr>
    <%
        List<FinAsset> finAssets = (List<FinAsset>) request.getAttribute("finAssets");
        if (finAssets != null) {
            for (FinAsset asset : finAssets) {
    %>
    <tr>
        <td><%= asset.getId() %></td>
        <td><%= asset.getTiker().getNameTiker() %></td>
        <td><%= asset.getTiker().getDealPlace() %></td>
        <td><%= asset.getRegistration() %></td>
        <td><%= asset.getDataRegistration() %></td>
        <td><%= asset.getEmitent() %></td>
        <td><%= asset.getFormIssue() %></td>
        <td><%= asset.getPrincipal() %></td>
        <td><%= asset.getAmount() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="9">Нет данных</td></tr>
    <% } %>
</table>

<h2>Список акций</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Финансовый инструмент</th>
        <th>Дата размещения</th>
        <th>Дата регистрации отчета</th>
    </tr>
    <%
        List<Security> securities = (List<Security>) request.getAttribute("securities");
        if (securities != null) {
            for (Security security : securities) {
    %>
    <tr>
        <td><%= security.getId() %></td>
        <td><%= security.getFinAsset().getEmitent() %></td>
        <td><%= security.getDateAccommodation() %></td>
        <td><%= security.getDateReport() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="4">Нет данных</td></tr>
    <% } %>
</table>

<h2>Список облигаций</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Финансовый инструмент</th>
        <th>Дата погашения</th>
        <th>Количество купонов</th>
        <th>Размер купона</th>
    </tr>
    <%
        List<Bond> bonds = (List<Bond>) request.getAttribute("bonds");
        if (bonds != null) {
            for (Bond bond : bonds) {
    %>
    <tr>
        <td><%= bond.getId() %></td>
        <td><%= bond.getFinAsset().getEmitent() %></td>
        <td><%= bond.getDataRepayment() %></td>
        <td><%= bond.getCouponsAmount() %></td>
        <td><%= bond.getCouponsRate() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="5">Нет данных</td></tr>
    <% } %>
</table>
</body>
</html>
