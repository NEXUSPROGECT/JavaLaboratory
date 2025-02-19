package com.example.testee0.servlet;

import com.example.testee0.domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products") // URL: http://localhost:8080/demo1_war_exploded/products
public class ProductServlet extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        products.add(new Product("Телевизор", "55 дюймов", 18.5));
        products.add(new Product("Холодильник", "180 см", 75.0));
        products.add(new Product("Смартфон", "6.5 дюймов", 0.2));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}

