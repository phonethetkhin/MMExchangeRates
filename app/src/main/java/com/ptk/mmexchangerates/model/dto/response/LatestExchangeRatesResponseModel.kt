@file:OptIn(InternalSerializationApi::class)

package com.ptk.mmexchangerates.model.dto.response

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class LatestExchangeRatesResponseModel(
    val description: String,
    val info: String,
    val rates: LinkedHashMap<String, String>,
)

