package com.example.chuyewyee.presentation.api

import com.example.chuyewyee.presentation.aip.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>

    @GET("pokemon/{{id}}")
    fun getPokemonDetail(@Path("id") id String): Call<PokemonDetailResponse>
}