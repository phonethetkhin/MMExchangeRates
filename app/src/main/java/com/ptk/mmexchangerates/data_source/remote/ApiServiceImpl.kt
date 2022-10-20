package com.ptk.mmexchangerates.data_source.remote

import com.ptk.mmexchangerates.model.dto.response.CurrenciesResponseModel
import com.ptk.mmexchangerates.model.dto.response.LatestExchangeRatesResponseModel
import com.ptk.mmexchangerates.util.BASE_URL
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiServiceImpl @Inject constructor(private val client: HttpClient) : ApiService {
    override suspend fun getLatestExchangeRates(): LatestExchangeRatesResponseModel = client.get {
        url(BASE_URL + APIRoutes.getLatestExchangeRates)
        contentType(ContentType.Application.Json)
    }

    override suspend fun getCurrencies(): CurrenciesResponseModel = client.get {
        url(BASE_URL + APIRoutes.getCurrencies)
        contentType(ContentType.Application.Json)
    }

    override suspend fun getHistory(date: String): LatestExchangeRatesResponseModel = client.get {
        url(BASE_URL + APIRoutes.getHistory + "/$date")
        contentType(ContentType.Application.Json)
    }
}