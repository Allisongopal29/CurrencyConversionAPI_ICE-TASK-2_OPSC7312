package com.opsc7312.currencyconversionapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyApiService {
    @GET("/v2/currency")
    fun getExchangeRate(
        @Query("api_key") apiKey: String?,
        @Query("from") fromCurrency: String?,
        @Query("to") toCurrency: String?,
        @Query("amount") amount: String?
    ): Call<CurrencyResponse?>?
}