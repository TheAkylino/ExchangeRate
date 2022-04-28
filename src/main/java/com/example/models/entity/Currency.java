package com.example.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE_ISO")
    private String codeIso;

    @Column(name = "DESCRIPTION_CURRENCY")
    private String description;

    @Column(name = "COUNTRY")
    private String country;
}
