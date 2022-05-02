package com.example.models.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXCHANGE_RATE")
@ApiModel(description = "Todo los detalles del tipo de cambio")
public class ExchangeRate extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID del tipo de cambio")
    private Integer id;

    @Column(name = "CODE_ISO_ORIGIN_CURRENCY", nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda de origen")
    @NotBlank(message = "El código Origen Moneda es obligatorio")
    private String codeOriginCurrency;

    @Column(name = "CODE_ISO_DESTINATION_CURRENCY", nullable = false)
    @ApiModelProperty(notes = "Codigo iso de la moneda de destino")
    @NotBlank(message = "El código Destino Moneda es obligatorio")
    private String codeDestinationCurrency;

    @Column(name = "RATE_OF_EXCHANGE", nullable = false)
    @ApiModelProperty(notes = "MONTO DE LA TAZA DE CAMBIO")
//    @NotBlank(message = "La taza de cambio es obligatorio")
    private BigDecimal rateExchange;
}
