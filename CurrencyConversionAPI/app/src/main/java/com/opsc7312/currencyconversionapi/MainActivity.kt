package com.opsc7312.currencyconversionapi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.opsc7312.currencyconversionapi.ApiClient.client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var resultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById<TextView>(R.id.resultTextView)
        val apiService = client!!.create(
            CurrencyApiService::class.java
        )
        val call = apiService.getExchangeRate("your_api_key", "USD", "EUR", "1")
        call!!.enqueue(object : Callback<CurrencyResponse?> {
            override fun onResponse(
                call: Call<CurrencyResponse?>,
                response: Response<CurrencyResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    resultTextView.setText("Exchange Rate: " + response.body()!!.rate)
                }
            }

            override fun onFailure(call: Call<CurrencyResponse?>, t: Throwable) {
                resultTextView.setText("Error: " + t.message)
            }
        })
    }
}

