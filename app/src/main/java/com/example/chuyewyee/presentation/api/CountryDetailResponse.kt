package com.example.chuyewyee.presentation.api

data class CountryDetailResponse {
    val types: List<CountrySlot>
}

data class CountrySlot (
    val slot: Int,
    val type: CountryType
)

data class CountryType (
    val name: String,
    val url: String
)