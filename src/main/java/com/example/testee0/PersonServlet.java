package com.example.testee0;

import com.example.testee0.Person;
import com.example.testee0.Role;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    private List<Person> people = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Добавляем тестовые данные (как база данных в памяти)
        Role developer = new Role(1L, "Разработчик");
        Role manager = new Role(2L, "Менеджер");

        people.add(new Person(1L, "Иван", "Иванов", "89001234567", "ivan@example.com", 1L, developer));
        people.add(new Person(2L, "Анна", "Петрова", "89169876543", "anna@example.com", 2L, manager));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Отправляем список сотрудников в JSP
        request.setAttribute("people", people);
        request.getRequestDispatcher("/persons.jsp").forward(request, response);
    }
}
