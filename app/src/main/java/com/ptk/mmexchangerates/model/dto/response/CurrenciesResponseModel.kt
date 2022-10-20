package com.ptk.mmexchangerates.model.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class CurrenciesResponseModel(
    val currencies: LinkedHashMap<String, String>,
    val description: String,
    val info: String
)