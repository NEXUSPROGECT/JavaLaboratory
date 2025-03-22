package com.example.testee0.servlet;

import com.example.testee0.db.ProductsDB;
import com.example.testee0.domain.Manufacturer;
import com.example.testee0.domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/productsAdd")
public class ProductServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("productsAddItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String size = request.getParameter("size");
        double weight = Double.parseDouble(request.getParameter("weight"));

        Product product = new Product(name, size, weight);
        ProductsDB.insert(product);

        response.sendRedirect(request.getContextPath() + "/products");
    }
}
