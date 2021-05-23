package com.example.chuyewyee.presentation.aip

import com.example.chuyewyee.presentation.list.Country

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<Country>
)