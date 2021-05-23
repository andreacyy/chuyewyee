package com.example.chuyewyee.presentation.api

data class PokemonDetailResponse {
    val types: List<PokemonSlot>
}

data class PokemonSlot (
    val slot: Int,
    val type: PokemonType
)

data class PokemonType (
    val name: String,
    val url: String
)