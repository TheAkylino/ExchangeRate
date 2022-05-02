package com.example.models.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY")
@ApiModel(description="Todo los detalles de la moneda")
public class Currency extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @ApiModelProperty(notes = "ID de la moneda")
    private Integer id;

    @Column(name = "CODE_ISO", nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda")
    @NotBlank(message = "El codeIso la moneda es obligatorio")
    private String codeIso;

    @Column(name = "DESCRIPTION_CURRENCY",nullable = false)
    @ApiModelProperty(notes = "Descripcion de la moneda")
    @NotBlank(message = "La Descripcion de la moneda es obligatorio")
    private String description;

    @Column(name = "COUNTRY", nullable = false)
    @ApiModelProperty(notes = "País de orige moneda")
    @NotBlank(message = "El pais de la moneda es obligatorio")
    private String country;
}
