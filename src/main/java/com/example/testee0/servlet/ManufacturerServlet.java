package com.example.testee0.servlet;

import com.example.testee0.domain.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manufacturers") // URL: http://localhost:8080/demo1_war_exploded/manufacturers
public class ManufacturerServlet extends HttpServlet {
    private List<Manufacturer> manufacturers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        manufacturers.add(new Manufacturer("Samsung", "Южная Корея", "Ким Чан", "+82 10-1234-5678"));
        manufacturers.add(new Manufacturer("Apple", "США", "Джон Смит", "+1 555-234-5678"));
        manufacturers.add(new Manufacturer("Xiaomi", "Китай", "Лэй Цзюнь", "+86 138-1234-5678"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("manufacturers", manufacturers);
        request.getRequestDispatcher("manufacturers.jsp").forward(request, response);
    }
}

