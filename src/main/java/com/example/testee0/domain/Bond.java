package com.example.testee0.domain;

import java.util.Date;

/**
 * Класс облигации
 */
public class Bond {
    private Long id; // Суррогатный ключ
    private FinAsset finAsset; // Внешний ключ на FinAsset
    private Date dataRepayment; // Дата погашения купона
    private int couponsAmount; // Количество купонов
    private double couponsRate; // Размер купона

    public Bond() {}

    public Bond(Long id, FinAsset finAsset, Date dataRepayment, int couponsAmount, double couponsRate) {
        this.id = id;
        this.finAsset = finAsset;
        this.dataRepayment = dataRepayment;
        this.couponsAmount = couponsAmount;
        this.couponsRate = couponsRate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FinAsset getFinAsset() { return finAsset; }
    public void setFinAsset(FinAsset finAsset) { this.finAsset = finAsset; }

    public Date getDataRepayment() { return dataRepayment; }
    public void setDataRepayment(Date dataRepayment) { this.dataRepayment = dataRepayment; }

    public int getCouponsAmount() { return couponsAmount; }
    public void setCouponsAmount(int couponsAmount) { this.couponsAmount = couponsAmount; }

    public double getCouponsRate() { return couponsRate; }
    public void setCouponsRate(double couponsRate) { this.couponsRate = couponsRate; }

    @Override
    public String toString() {
        return "Bond { ID=" + id + ", FinAsset=" + finAsset.getEmitent() +
                ", DataRepayment=" + dataRepayment + ", CouponsAmount=" + couponsAmount +
                ", CouponsRate=" + couponsRate + " }";
    }
}
