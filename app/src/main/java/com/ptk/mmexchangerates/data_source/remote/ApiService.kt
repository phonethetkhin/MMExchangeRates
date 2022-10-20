package com.ptk.mmexchangerates.data_source.remote

import com.ptk.mmexchangerates.model.dto.response.CurrenciesResponseModel
import com.ptk.mmexchangerates.model.dto.response.LatestExchangeRatesResponseModel


interface ApiService {

    suspend fun getLatestExchangeRates(): LatestExchangeRatesResponseModel
    suspend fun getCurrencies(): CurrenciesResponseModel
    suspend fun getHistory(date: String): LatestExchangeRatesResponseModel

}