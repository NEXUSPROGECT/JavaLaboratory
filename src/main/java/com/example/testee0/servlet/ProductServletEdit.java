package com.example.testee0.servlet;

import com.example.testee0.db.ProductsDB;
import com.example.testee0.domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productsEdit")
public class ProductServletEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> products = ProductsDB.select();
        Product product = products.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("productsEdit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String size = request.getParameter("size");
        double weight = Double.parseDouble(request.getParameter("weight"));

        Product product = new Product(id, name, size, weight);
        ProductsDB.update(product);

        response.sendRedirect(request.getContextPath() + "/products");
    }
}
