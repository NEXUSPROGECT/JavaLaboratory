package com.example.testee0.domain;

import java.util.Date;

/**
 * Класс акции
 */
public class Security {
    private Long id; // Суррогатный ключ
    private FinAsset finAsset; // Внешний ключ на FinAsset
    private Date dateAccommodation; // Дата размещения
    private Date dateReport; // Дата регистрации отчета о размещении

    public Security() {}

    public Security(Long id, FinAsset finAsset, Date dateAccommodation, Date dateReport) {
        this.id = id;
        this.finAsset = finAsset;
        this.dateAccommodation = dateAccommodation;
        this.dateReport = dateReport;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FinAsset getFinAsset() { return finAsset; }
    public void setFinAsset(FinAsset finAsset) { this.finAsset = finAsset; }

    public Date getDateAccommodation() { return dateAccommodation; }
    public void setDateAccommodation(Date dateAccommodation) { this.dateAccommodation = dateAccommodation; }

    public Date getDateReport() { return dateReport; }
    public void setDateReport(Date dateReport) { this.dateReport = dateReport; }

    @Override
    public String toString() {
        return "Security { ID=" + id + ", FinAsset=" + finAsset.getEmitent() +
                ", DateAccommodation=" + dateAccommodation + ", DateReport=" + dateReport + " }";
    }
}