package com.example.testee0.servlet;

import com.example.testee0.db.ProductsDB;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = ProductsDB.select();
        request.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
    }
}

