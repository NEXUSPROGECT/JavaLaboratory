package com.example.testee0.db;

import com.example.testee0.domain.Manufacturer;

import java.sql.*;
import java.util.ArrayList;

public class ManufacturerDB {
    private static String url = "jdbc:mysql://localhost/prod_and_manuf";
    private static String username = "user";
    private static String password = "1234";

    public static ArrayList<Manufacturer> select() {


        ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM manufacturer");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    String contactPerson = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    Manufacturer manufacturer = new Manufacturer(id, name, country, contactPerson, phone);
                    manufacturers.add(manufacturer);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return manufacturers;

    }

    public static int insert(Manufacturer manufacturer) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO manufacturer (name, country, contactPerson, phone) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, manufacturer.getName());
                    preparedStatement.setString(2, manufacturer.getCountry());
                    preparedStatement.setString(3, manufacturer.getContactPerson());
                    preparedStatement.setString(4, manufacturer.getPhone());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Manufacturer manufacturer) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "UPDATE manufacturer SET name = ?, country = ?, contactPerson = ?, phone = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, manufacturer.getName());
                    preparedStatement.setString(2, manufacturer.getCountry());
                    preparedStatement.setString(3, manufacturer.getContactPerson());
                    preparedStatement.setString(4, manufacturer.getPhone());
                    preparedStatement.setInt(5, manufacturer.getId());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "DELETE FROM manufacturer WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}