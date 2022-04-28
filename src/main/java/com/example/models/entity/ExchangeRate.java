package com.example.models.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXCHANGE_RATE")
@ApiModel(description="Todo los detalles del tipo de cambio")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID del tipo de cambio")
    private Integer id;

    @Column(name = "CODE_ISO_ORIGIN_CURRENCY" ,nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda de origen")
    private String codeOriginCurrency;

    @Column(name = "CODE_ISO_DESTINATION_CURRENCY" ,nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda de destino")
    private String codeDestinationCurrency;

    @Column(name = "AMOUNT" ,nullable = false)
    @ApiModelProperty(notes = "Monto del tipo de cambio")
    private BigDecimal amount;
}
