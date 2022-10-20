package com.ptk.mmexchangerates.view.ui_resources.ui_state

import com.ptk.mmexchangerates.model.ExchangeRatesModel
import com.ptk.mmexchangerates.model.dto.CurrencyModel

data class UIStates(
    val showLoadingDialog: Boolean = false,
    val rates: ArrayList<ExchangeRatesModel>? = null,
    val currencies: ArrayList<CurrencyModel>? = null,
    val selectedDate: String? = null,
    val noResult: Boolean = false,
    val selectedCurrency: String = "",
    val convertedResult: String? = null,
)