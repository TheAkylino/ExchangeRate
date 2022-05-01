package com.example.dtos.reponse;

import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeExchangeRateResponse {
    private BigDecimal amount;
    private BigDecimal exchanged_amount;
    private String origin_currency;
    private String destination_currency;
    private BigDecimal exchange_rate;
}
