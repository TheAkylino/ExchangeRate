package com.example.models.service;

import com.example.models.entity.Currency;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface ExchangeRateService {

    Flowable<Currency> listCurrency();
    Maybe<Currency> currencyById(Integer id);
    Single<Currency> saveCurrency(Currency currency);
    Single<Currency> updateCurrency(Currency currency);
}
