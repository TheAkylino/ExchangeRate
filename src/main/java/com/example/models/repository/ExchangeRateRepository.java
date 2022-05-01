package com.example.models.repository;

import com.example.models.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate,Integer> {

    Optional<ExchangeRate> findByCodeOriginCurrencyAndCodeDestinationCurrency(String codeOriginCurrency, String codeDestinationCurrency);

    Optional<ExchangeRate> findById(Integer id);

    @Override
    ExchangeRate save(ExchangeRate exchangeRate);

    @Override
    Iterable<ExchangeRate> findAll();

    @Override
    void deleteById(Integer id);
}
