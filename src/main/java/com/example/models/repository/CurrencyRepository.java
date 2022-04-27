package com.example.models.repository;

import com.example.models.entity.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<Currency,Integer> {

    Optional<Currency> findByCodeIso(String code);
    Optional<Currency> findById(Integer id);

    @Override
    Currency save(Currency currency);

    @Override
    Iterable<Currency> findAll();

    @Override
    void deleteById(Integer id);
}
