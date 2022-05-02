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

import javax.validation.Valid;
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
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @GetMapping("/allCurrency")
    public Flowable<Currency> listCurrency() {
        log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
        return exchangeRateService.listCurrency()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listCurrency", throwable.getMessage()));
    }

    @ApiOperation(value = "Obtener las Moneda por Id", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Moneda por Id recuperada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @GetMapping("/currencyById/{id}")
    public Maybe<Currency> currencyById(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "currencyById");
        return exchangeRateService.currencyById(id)
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "currencyById"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "currencyById", throwable.getMessage()));
    }

    @ApiOperation(value = "Crear Nueva Mondeda", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La Moneda ha sido crearda correctamente"),
            @ApiResponse(code = 201, message = "La Moneda se ha creado un exito"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @PostMapping("/addCurrency")
    public Single<Currency> addCurrency(@Valid @RequestBody Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateController", "addCurrency");
        return exchangeRateService.saveCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "addCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "addCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "addCurrency"));
    }

    @ApiOperation(value = "Modificar una Mondeda Existente", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La Moneda ha sido modificada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @PutMapping("/modifyCurrency")
    public Single<Currency> updateCurrency(@Valid @RequestBody Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
        return exchangeRateService.updateCurrency(currency)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "updateCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "updateCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "updateCurrency"));
    }

    @ApiOperation(value = "Borrar una Mondeda Existente", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La Moneda ha sido borrada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @DeleteMapping("/deleteCurrency/{id}")
    public Completable deleteCurrencyById(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "deleteCurrencyById");
        return exchangeRateService.deleteCurrencyById(id);
    }

    @ApiOperation(value = "Lista de todas Tipo de cambio", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Los Tipo de cambio ha recuperada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @GetMapping("/allExchangeRate")
    public Flowable<ExchangeRate> listExchangeRate() {
        log.info("Starting {}.{} method", "ExchangeRateController", "listExchangeRate");
        return exchangeRateService.listExchangeRate()
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController",
                        "listExchangeRate"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "listExchangeRate", throwable.getMessage()));
    }

    @ApiOperation(value = "Obtener el tipo de cambio por Id", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tipo de cambio por ID ha recuperada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @GetMapping("/exchangeRateById/{id}")
    public Maybe<ExchangeRate> ExchangeRateId(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "exchangeRateById");
        return exchangeRateService.ExchangeRateById(id)
                .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController", "exchangeRateById"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "exchangeRateById", throwable.getMessage()));
    }


    @ApiOperation(value = "Crear el tipo de cambio", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "El Tipo de cambio ha sido crearda correctamente"),
            @ApiResponse(code = 201, message = "El tipo de cambio se ha creado un exito"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @PostMapping("/addExchangeRate")
    public Single<ExchangeRate> addExchangeRate(@Valid @RequestBody ExchangeRate exchangeRate) {
        log.info("Starting {}.{} method", "ExchangeRateController", "addExchangeRate");
        return exchangeRateService.saveExchangeRate(exchangeRate)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "addExchangeRate", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "addExchangeRate", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "addExchangeRate"));
    }

    @ApiOperation(value = "Modificar el tipo de cambio", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "El Tipo de cambio ha sido modificada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @PutMapping("/modifyExchangeRate")
    public Single<ExchangeRate> updateExchangeRate(@Valid @RequestBody ExchangeRate exchangeRate) {
        log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
        return exchangeRateService.updateExchangeRate(exchangeRate)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "updateExchangeRate", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "updateExchangeRate", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "updateExchangeRate"));
    }

    @ApiOperation(value = "Borrar el tipo de cambio", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "El Tipo de cambio ha sido borrada correctamente"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @DeleteMapping("/deleteExchangeRate/{id}")
    public Completable deleteExchangeRateById(@PathVariable Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateController", "deleteCurrencyById");
        return exchangeRateService.deleteExchangeRateById(id);
    }

    @ApiOperation(value = "Calcular el tipo de cambio", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Calculalo del Tipo de cambio"),
            @ApiResponse(code = 401, message = "No está autorizado para ver el recurso."),
            @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder."),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que intentabas acceder")})
    @PostMapping("/calculateExchangeRate")
    public Single<ChangeExchangeRateResponse> changeExchangeRate(@Valid @RequestBody ChangeExchangeRateRequest request) {
        log.info("Starting {}.{} method", "ExchangeRateController", "changeExchangeRate");
        return exchangeRateService.calculateExchangeRate(request)
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "changeExchangeRate", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
                        "changeExchangeRate", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "changeExchangeRate"));
    }
}
