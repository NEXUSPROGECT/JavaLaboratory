package com.example.testee0.servlet;

import com.example.testee0.db.ManufacturerDB;
import com.example.testee0.domain.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/manufacturersEdit")
public class ManufacturerServletEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Manufacturer> manufacturers = ManufacturerDB.select();
        Manufacturer manufacturer = manufacturers.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (manufacturer != null) {
            request.setAttribute("manufacturer", manufacturer);
            request.getRequestDispatcher("manufacturersEdit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/manufacturers");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String contactPerson = request.getParameter("contactPerson");
        String phone = request.getParameter("phone");

        Manufacturer manufacturer = new Manufacturer(id, name, country, contactPerson, phone);
        ManufacturerDB.update(manufacturer);

        response.sendRedirect(request.getContextPath() + "/manufacturers");
    }
}
