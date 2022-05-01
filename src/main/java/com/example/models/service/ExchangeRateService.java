package com.example.models.service;

import com.example.dtos.reponse.ChangeExchangeRateResponse;
import com.example.dtos.request.ChangeExchangeRateRequest;
import com.example.models.entity.Currency;
import com.example.models.entity.ExchangeRate;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface ExchangeRateService {

    Flowable<Currency> listCurrency();
    Maybe<Currency> currencyById(Integer id);
    Single<Currency> saveCurrency(Currency currency);
    Single<Currency> updateCurrency(Currency currency);
    Completable deleteCurrencyById(Integer id);

    Flowable<ExchangeRate> listExchangeRate();
    Maybe<ExchangeRate>  ExchangeRateById(Integer id);
    Single<ExchangeRate> saveExchangeRate(ExchangeRate exchangeRate);
    Single<ExchangeRate> updateExchangeRate(ExchangeRate exchangeRate);
    Completable deleteExchangeRateById(Integer id);
    Single<ChangeExchangeRateResponse> calculateExchangeRate(ChangeExchangeRateRequest request);
}
