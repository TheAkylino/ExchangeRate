package com.example.models.repository;

import com.example.models.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<Currency,Integer> {

    Optional<Currency> findById(Integer id);

    @Override
    Currency save(Currency currency);

    @Override
    Iterable<Currency> findAll();

    @Override
    void deleteById(Integer id);

    @Query(
            value = "SELECT * FROM CURRENCY C WHERE C.CODE_ISO = :code",
            nativeQuery = true)
    Optional<Currency> findByCode(@Param("code") String name);
}
