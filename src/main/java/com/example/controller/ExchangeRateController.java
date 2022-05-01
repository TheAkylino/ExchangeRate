package com.example.controller;

import com.example.dtos.reponse.ChangeExchangeRateResponse;
import com.example.dtos.request.ChangeExchangeRateRequest;
import com.example.models.entity.Currency;
import com.example.models.entity.ExchangeRate;
import com.example.models.service.ExchangeRateService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/exchange-rate/api/v1")
@Api(value = "Proyecto de tipo de cambio", description = "Proyecto elaborado en Spring Boot")
public class ExchangeRateController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @ApiOperation(value = "Lista de todas las monedas", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Lista recuperada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @GetMapping("/allCurrency")
    public Flowable<Currency> listCurrency() {
        log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
        return exchangeRateService.listCurrency()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @GetMapping("/currencyById/{id}")
    public Maybe<Currency> currencyById(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "currencyById");
        return exchangeRateService.currencyById(id)
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @PostMapping("/addCurrency")
    public Single<Currency> addCurrency(@RequestBody Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateController", "addCurrency");
        return exchangeRateService.saveCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @PutMapping("/modifyCurrency")
    public Single<Currency> updateCurrency(@RequestBody Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
        return exchangeRateService.updateCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @DeleteMapping("/deleteCurrency/{id}")
    public Completable deleteCurrencyById(@PathVariable Integer id) {
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

    @GetMapping("/exchangeRateById/{id}")
    public Maybe<ExchangeRate> ExchangeRateId(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "ExchangeRateId");
        return exchangeRateService.ExchangeRateById(id)
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "ExchangeRateId"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @PostMapping("/addExchangeRate")
    public Single<ExchangeRate> addExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        log.info("Starting {}.{} method", "ExchangeRateController", "addCurrency");
        return exchangeRateService.saveExchangeRate(exchangeRate)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @PutMapping("/modifyExchangeRate")
    public Single<ExchangeRate> updateExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
        return exchangeRateService.updateExchangeRate(exchangeRate)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
    }

    @DeleteMapping("/deleteExchangeRate/{id}")
    public Completable deleteExchangeRateById(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "deleteCurrencyById");
        return exchangeRateService.deleteExchangeRateById(id);
    }

    @PostMapping("/calculateExchangeRate")
    public Single<ChangeExchangeRateResponse> changeExchangeRate(@RequestBody ChangeExchangeRateRequest request) {
        log.info("Starting {}.{} method", "ExchangeRateController", "changeExchangeRate");
        return exchangeRateService.calculateExchangeRate(request)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "changeExchangeRate", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "changeExchangeRate"));
    }
}
