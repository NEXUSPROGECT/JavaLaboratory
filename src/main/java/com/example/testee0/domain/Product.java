package com.example.testee0.domain;

/**
 * Класс "Товар"
 */
public class Product {
    private int id;
    private String name; // Наименование
    private String size; // Размер
    private double weight; // Вес

    public Product() {}

    public Product(int id, String name, String size, double weight) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    @Override
    public String toString() {
        return "Product { Name=" + name + ", Size=" + size + ", Weight=" + weight + "kg }";
    }
}

