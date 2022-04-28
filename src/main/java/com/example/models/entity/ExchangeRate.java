package com.example.models.entity;

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
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CODE_ISO_ORIGIN_CURRENCY")
    private String codeOriginCurrency;

    @Column(name = "CODE_ISO_DESTINATION_CURRENCY")
    private String codeDestinationCurrency;

    @Column(name = "EXCHANGE_RATE")
    private BigDecimal exchangeRate;
}
