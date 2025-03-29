package com.example.labwork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "fin_asset")
public class FinAsset {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiker_id")
    private com.example.labwork.models.Tiker tiker;

    @Column(name = "registration", length = 50)
    private String registration;

    @Column(name = "data_registration")
    private LocalDate dataRegistration;

    @Column(name = "emitent", length = 30)
    private String emitent;

    @Column(name = "form_issue", length = 20)
    private String formIssue;

    @Column(name = "principal", length = 20)
    private String principal;

    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "finAsset")
    private Set<Bond> bonds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "finAsset")
    private Set<com.example.labwork.models.Securit> securits = new LinkedHashSet<>();

}