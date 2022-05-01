package com.example.dtos.request;

import lombok.*;

import java.math.BigDecimal;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeExchangeRateRequest {
    private String codeOriginCurrency;
    private String codeDestinationCurrency;
    private BigDecimal amountChange;
}
