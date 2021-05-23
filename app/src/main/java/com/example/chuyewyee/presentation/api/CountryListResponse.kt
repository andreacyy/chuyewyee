package com.example.chuyewyee.presentation.api

import android.graphics.Region
import com.example.chuyewyee.presentation.list.Country

data class CountryListResponse(
    val name: Int,
    val region: String,
    val incomeLevel: String
)