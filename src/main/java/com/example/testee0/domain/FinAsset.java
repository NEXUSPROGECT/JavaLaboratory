package com.example.testee0.domain;

import java.util.Date;

/**
 * Класс финансового инструмента
 */
public class FinAsset {
    private Long id; // Суррогатный ключ
    private Tiker tiker; // Внешний ключ на Tiker
    private String registration; // Орган регистрации
    private Date dataRegistration; // Дата регистрации ЦБ
    private String emitent; // Эмитент
    private String formIssue; // Форма выпуска (наличная, безналичная)
    private double principal; // Номинал
    private int amount; // Количество ЦБ в выпуске

    public FinAsset() {}

    public FinAsset(Long id, Tiker tiker, String registration, Date dataRegistration,
                    String emitent, String formIssue, double principal, int amount) {
        this.id = id;
        this.tiker = tiker;
        this.registration = registration;
        this.dataRegistration = dataRegistration;
        this.emitent = emitent;
        this.formIssue = formIssue;
        this.principal = principal;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Tiker getTiker() { return tiker; }
    public void setTiker(Tiker tiker) { this.tiker = tiker; }

    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }

    public Date getDataRegistration() { return dataRegistration; }
    public void setDataRegistration(Date dataRegistration) { this.dataRegistration = dataRegistration; }

    public String getEmitent() { return emitent; }
    public void setEmitent(String emitent) { this.emitent = emitent; }

    public String getFormIssue() { return formIssue; }
    public void setFormIssue(String formIssue) { this.formIssue = formIssue; }

    public double getPrincipal() { return principal; }
    public void setPrincipal(double principal) { this.principal = principal; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "FinAsset { ID=" + id + ", Tiker=" + tiker.getNameTiker() + ", Registration=" + registration +
                ", DataRegistration=" + dataRegistration + ", Emitent=" + emitent +
                ", FormIssue=" + formIssue + ", Principal=" + principal + ", Amount=" + amount + " }";
    }
}
