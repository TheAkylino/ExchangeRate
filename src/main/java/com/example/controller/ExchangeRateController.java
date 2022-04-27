package com.example.controller;

import com.example.models.entity.Currency;
import com.example.models.service.ExchangeRateService;
import io.reactivex.Flowable;
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
    public Flowable<Currency> currencyById(@PathVariable Integer id){
        log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
        return exchangeRateService.listCurrency()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @PostMapping("/addCurrency")
    public Single<Currency> addCurrency(@RequestBody Currency currency){
        log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
        return exchangeRateService.saveCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController", "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }
}
