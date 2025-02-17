package com.example.testee0.domain;

/**
 * Класс "Производитель"
 */
public class Manufacturer {
    private String name; // Название
    private String country; // Страна
    private String contactPerson; // Контактное лицо
    private String phone; // Телефон

    public Manufacturer() {}

    public Manufacturer(String name, String country, String contactPerson, String phone) {
        this.name = name;
        this.country = country;
        this.contactPerson = contactPerson;
        this.phone = phone;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Manufacturer { Name=" + name + ", Country=" + country +
                ", ContactPerson=" + contactPerson + ", Phone=" + phone + " }";
    }
}

