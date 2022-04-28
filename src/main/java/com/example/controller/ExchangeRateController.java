package com.example.controller;

import com.example.models.entity.Currency;
import com.example.models.entity.ExchangeRate;
import com.example.models.service.ExchangeRateService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/exchange-rate/api/v1")
public class ExchangeRateController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @GetMapping("/allCurrency")
    public Flowable<Currency> listCurrency(){
        log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
        return exchangeRateService.listCurrency()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @GetMapping("/currencyById/{id}")
    public Maybe<Currency> currencyById(@PathVariable Integer id){
        log.info("Starting {}.{} method", "ExchangeRateController", "currencyById");
        return exchangeRateService.currencyById(id)
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @PostMapping("/addCurrency")
    public Single<Currency> addCurrency(@RequestBody Currency currency){
        log.info("Starting {}.{} method", "ExchangeRateController", "addCurrency");
        return exchangeRateService.saveCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @PutMapping("/modifyCurrency")
    public Single<Currency> updateCurrency(@RequestBody Currency currency){
        log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
        return exchangeRateService.updateCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @DeleteMapping("/deleteCurrency/{id}")
    public Completable deleteCurrencyById(@PathVariable Integer id){
        log.info("Starting {}.{} method", "ExchangeRateController", "deleteCurrencyById");
        return exchangeRateService.deleteCurrencyById(id);
    }

    @GetMapping("/allExchangeRate")
    public Flowable<ExchangeRate> listExchangeRate() {
        log.info("Starting {}.{} method", "ExchangeRateController", "listExchangeRate");
        return exchangeRateService.listExchangeRate()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController",
                        "listExchange"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listExchange", throwable.getMessage()));
    }


}
