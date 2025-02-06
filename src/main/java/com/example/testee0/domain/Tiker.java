package com.example.testee0.domain;

/**
 * Класс тикера ценной бумаги
 */
public class Tiker {
    private Long id; // Суррогатный ключ
    private String nameTiker; // Тикер ценной бумаги
    private String dealPlace; // Торговая (биржевая) площадка

    public Tiker() {}

    public Tiker(Long id, String nameTiker, String dealPlace) {
        this.id = id;
        this.nameTiker = nameTiker;
        this.dealPlace = dealPlace;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNameTiker() { return nameTiker; }
    public void setNameTiker(String nameTiker) { this.nameTiker = nameTiker; }

    public String getDealPlace() { return dealPlace; }
    public void setDealPlace(String dealPlace) { this.dealPlace = dealPlace; }

    @Override
    public String toString() {
        return "Tiker { ID=" + id + ", NameTiker=" + nameTiker + ", DealPlace=" + dealPlace + " }";
    }
}