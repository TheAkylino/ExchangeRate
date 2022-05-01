package com.example.models.service.impl;

import com.example.dtos.reponse.ChangeExchangeRateResponse;
import com.example.dtos.request.ChangeExchangeRateRequest;
import com.example.models.entity.Currency;
import com.example.models.entity.ExchangeRate;
import com.example.models.repository.CurrencyRepository;
import com.example.models.repository.ExchangeRateRepository;
import com.example.models.service.ExchangeRateService;
import com.example.exceptions.CurrencyIdNotNullException;
import com.example.exceptions.CurrencyNotFoundException;
import com.example.exceptions.ExchangeRateNotFoundException;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private Optional<Integer>  currencyId;
    private Optional<Currency> existsCurrencyById ;
    private Optional<ExchangeRate> existsExchangeRateById ;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Override
    public Flowable<Currency> listCurrency() {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "listCurrency");
        return Flowable.fromIterable(currencyRepository.findAll())
                .doOnComplete(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "listCurrency", throwable.getMessage()));
    }

    @Override
    public Maybe<Currency> currencyById(Integer idCurrency) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "currencyById");
        Optional<Currency> currencyById = currencyRepository.findById(idCurrency);
        currencyById.orElseThrow(() -> new CurrencyNotFoundException("NO EXISTE ESTE NUMERO DE ID N° '" + idCurrency + "'"));
        return currencyById.isPresent() ? Maybe.just(currencyById.get()) : Maybe.empty();
    }

    @Override
    public Single<Currency> saveCurrency(Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "saveCurrency");
        return Single.fromCallable(() -> currencyRepository.save(currency))
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "saveCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveCurrency"));
    }

    @Override
    public Single<Currency> updateCurrency(Currency currency) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "updateCurrency");
        currencyId = Optional.ofNullable(currency.getId());
        currencyId.orElseThrow(()-> new CurrencyIdNotNullException("EL N° DE ID DE ESTA MONEDA NO EXISTE"));

        existsCurrencyById = currencyRepository.findById(currency.getId());
        existsCurrencyById.orElseThrow(() -> new CurrencyNotFoundException("NO EXISTE ESTE N° ID '" + currency.getId() + "'"));
        return Single.fromCallable(()-> currencyRepository.save(currency))
                .doOnSuccess(s-> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "updateCurrency", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "updateCurrency", throwable.getMessage()))
                .doOnTerminate(()-> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveCurrency"));
    }

    @Override
    public Completable deleteCurrencyById(Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "deleteCurrencyById");
        currencyId = Optional.ofNullable(id);
        currencyId.orElseThrow(()-> new CurrencyIdNotNullException("EL N° DE ID DE ESTA MONEDA NO EXISTE"));

        existsCurrencyById = currencyRepository.findById(id);
        existsCurrencyById.orElseThrow(() -> new CurrencyNotFoundException("NO EXISTE ESTE N° ID '" + id + "'"));
        currencyRepository.deleteById(id);
        return Completable.complete();
    }

    @Override
    public Flowable<ExchangeRate> listExchangeRate() {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "deleteCurrencyById");
        return Flowable.fromIterable(exchangeRateRepository.findAll())
                .doOnComplete(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "listCurrency"))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "listCurrency", throwable.getMessage()));
    }

    @Override
    public Maybe<ExchangeRate> ExchangeRateById(Integer id) {
        Optional<ExchangeRate> exchangeOptional = exchangeRateRepository.findById(id);
        exchangeOptional.orElseThrow(()
                -> new ExchangeRateNotFoundException("No Existe este Numero de ID '"+id+"'"));
        return exchangeOptional.isPresent() ? Maybe.just(exchangeOptional.get()) : Maybe.empty();
    }

    @Override
    public Single<ExchangeRate> saveExchangeRate(ExchangeRate exchangeRate) {
        return Single.fromCallable(() -> exchangeRateRepository.save(exchangeRate))
                .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "saveExchange", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "saveCurrency", throwable.getMessage()))
                .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveExchange"));
    }

    @Override
    public Single<ExchangeRate> updateExchangeRate(ExchangeRate exchangeRate) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "updateExchangeRate");
        currencyId = Optional.ofNullable(exchangeRate.getId());
        currencyId.orElseThrow(()-> new CurrencyIdNotNullException("EL N° DE ID DE ESTA MONEDA NO EXISTE"));

        existsExchangeRateById = exchangeRateRepository.findById(exchangeRate.getId());
        existsExchangeRateById.orElseThrow(() -> new CurrencyNotFoundException("NO EXISTE ESTE N° ID '" + exchangeRate.getId() + "'"));
        return Single.fromCallable(()-> exchangeRateRepository.save(exchangeRate))
                .doOnSuccess(s-> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "updateExchangeRate", s))
                .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
                        "updateCurrency", throwable.getMessage()))
                .doOnTerminate(()-> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "updateExchangeRate"));
    }

    @Override
    public Completable deleteExchangeRateById(Integer id) {
        log.info("Starting {}.{} method", "ExchangeRateServiceImpl", "deleteCurrencyById");
        currencyId = Optional.ofNullable(id);
        currencyId.orElseThrow(()-> new CurrencyIdNotNullException("EL N° DE ID DE ESTA MONEDA NO EXISTE"));

        existsCurrencyById = currencyRepository.findById(id);
        existsCurrencyById.orElseThrow(() -> new ExchangeRateNotFoundException("NO EXISTE ESTE N° ID '" + id + "'"));
        currencyRepository.deleteById(id);
        return Completable.complete();
    }

    /**
     * Metodo calcular el tipo de cambio entre una moneda a otra
     * @param request
     * return single
     * */
    @Override
    public Single<ChangeExchangeRateResponse> calculateExchangeRate(ChangeExchangeRateRequest request) {
        ExchangeRate findExchangeRate = obtainExchange(request);

        BigDecimal monto = calculateExchangeRate(request.getAmountChange(), findExchangeRate.getRateExchange());
        return Single.fromCallable(() -> ChangeExchangeRateResponse.builder()
                .amount(request.getAmountChange())
                .exchanged_amount(monto)
                .origin_currency(getDescription(request.getCodeOriginCurrency()))
                .destination_currency(getDescription(request.getCodeDestinationCurrency()))
                .exchange_rate(findExchangeRate.getRateExchange())
                .build());
    }

    /**
     * Obtengo la taza de tipo de cambio por el código de la Moneda de Origen y el Código de la Moneda Destino
     * @param request
     * return single
     * */
    private ExchangeRate obtainExchange (ChangeExchangeRateRequest request){
        return  exchangeRateRepository
                .findByCodeOriginCurrencyAndCodeDestinationCurrency(request.getCodeOriginCurrency(),
                        request.getCodeDestinationCurrency())
                .orElseThrow(()->
                        new ExchangeRateNotFoundException("NO EXISTE UN TIPO DE CAMBIO RELACIONADO CON LA MONEDA DE ORIGEN Y DESTINO"));
    }

    private BigDecimal calculateExchangeRate(BigDecimal amount, BigDecimal exchangeRate) {
        return amount.multiply(exchangeRate);
    }

    private String getDescription(String destinationCurrencyCode) throws ExchangeRateNotFoundException {
        return currencyRepository.findByCode(destinationCurrencyCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("EL CÓDIGO DE MONEDA NO EXISTE"))
                .getDescription();
    }
}
