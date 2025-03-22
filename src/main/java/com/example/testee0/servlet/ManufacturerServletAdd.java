package com.example.testee0.servlet;

import com.example.testee0.db.ManufacturerDB;
import com.example.testee0.domain.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manufacturersAdd")
public class ManufacturerServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("manufacturersAddItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String contactPerson = request.getParameter("contactPerson");
        String phone = request.getParameter("phone");

        Manufacturer manufacturer = new Manufacturer(0, name, country, contactPerson, phone);
        ManufacturerDB.insert(manufacturer);

        response.sendRedirect(request.getContextPath() + "/manufacturers");
    }
}
