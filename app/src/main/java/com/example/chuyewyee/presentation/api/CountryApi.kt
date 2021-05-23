package com.example.chuyewyee.presentation.api

import com.example.chuyewyee.presentation.api.CountryListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {
    @GET("country")
    fun getCountryList(): Call<CountryListResponse>

    @GET("country/{{id}}")
    fun getCountryDetail(@Path("id") id: String): Call<CountryDetailResponse>
}