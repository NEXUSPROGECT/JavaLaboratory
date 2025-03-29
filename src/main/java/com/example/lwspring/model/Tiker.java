package com.example.labwork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tiker")
public class Tiker {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_tiker", length = 30)
    private String nameTiker;

    @Column(name = "deal_place", length = 20)
    private String dealPlace;

    @OneToMany(mappedBy = "tiker")
    private Set<FinAsset> finAssets = new LinkedHashSet<>();

}