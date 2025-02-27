package com.example.testee0.servlet;

import com.example.testee0.db.ManufacturerDB;
import com.example.testee0.domain.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manufacturers")
public class ManufacturerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Manufacturer> manufacturers = ManufacturerDB.select();
        request.setAttribute("manufacturers", manufacturers);

        getServletContext().getRequestDispatcher("/manufacturers.jsp").forward(request, response);
    }
}

