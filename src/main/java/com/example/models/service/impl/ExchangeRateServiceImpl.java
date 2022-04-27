package com.example.models.service.impl;

import com.example.models.entity.Currency;
import com.example.models.repository.CurrencyRepository;
import com.example.models.service.ExchangeRateService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Flowable<Currency> listCurrency() {
        return Flowable.fromIterable(currencyRepository.findAll())
                .doOnComplete(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "listCurrency", throwable.getMessage()));
    }

    @Override
    public Maybe<Currency> currencyById(Integer id) {
        Optional<Currency> currencyById = currencyRepository.findById(id);

        return null;
    }


    @Override
    public Single<Currency> saveCurrency(Currency currency) {
        return Single.fromCallable(() -> currencyRepository.save(currency))
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl", "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveCurrency"));
    }

    @Override
    public Single<Currency> updateCurrency(Currency currency) {
        return null;
    }
}
