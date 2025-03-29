package com.example.labwork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "securit")
public class Securit {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fin_asset_Id")
    private FinAsset finAsset;

    @Column(name = "Date_Accommodation")
    private LocalDate dateAccommodation;

    @Column(name = "Date_Report")
    private LocalDate dateReport;

}