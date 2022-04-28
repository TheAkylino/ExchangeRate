package com.example.models.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY")
@ApiModel(description="Todo los detalles de la moneda")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @ApiModelProperty(notes = "ID de la moneda")
    private Integer id;

    @Column(name = "CODE_ISO", nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda")
    private String codeIso;

    @Column(name = "DESCRIPTION_CURRENCY",nullable = false)
    @ApiModelProperty(notes = "Descripcion de la moneda")
    private String description;

    @Column(name = "COUNTRY", nullable = false)
    @ApiModelProperty(notes = "País de orige moneda")
    private String country;
}
