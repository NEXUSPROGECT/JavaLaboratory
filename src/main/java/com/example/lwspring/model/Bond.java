package com.example.labwork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bond")
public class Bond {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fin_asset_Id")
    private com.example.labwork.models.FinAsset finAsset;

    @Column(name = "Data_Repayment")
    private LocalDate dataRepayment;

    @Column(name = "coupons_amount")
    private Integer couponsAmount;

    @Column(name = "coupons_rate")
    private Float couponsRate;

}