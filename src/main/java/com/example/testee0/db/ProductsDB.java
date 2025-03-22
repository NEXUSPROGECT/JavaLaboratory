package com.example.testee0.db;

import com.example.testee0.domain.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductsDB {
    private static String url = "jdbc:mysql://localhost/prod_and_manuf";
    private static String username = "user";
    private static String password = "1234";

    public static ArrayList<Product> select() {


        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String size = resultSet.getString(3);
                    double weight = resultSet.getDouble(4);
                    Product product = new Product(id, name, size, weight);
                    products.add(product);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return products;

    }

    public static int insert(Product product) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO products (name, size, weight) Values (?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setString(2, product.getSize());
                    preparedStatement.setDouble(3, product.getWeight());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Product product) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "UPDATE products SET name = ?, size = ?, weight = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setString(2, product.getSize());
                    preparedStatement.setDouble(3, product.getWeight());
                    preparedStatement.setInt(4, product.getId());
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

                String sql = "DELETE FROM products WHERE id = ?";
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
