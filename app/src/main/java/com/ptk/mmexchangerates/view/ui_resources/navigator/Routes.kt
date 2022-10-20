package com.ptk.mmexchangerates.view.ui_resources.navigator

sealed class Routes(val route: String) {
    object ExchangeRatesScreen : Routes("/exchange_rates_screen")
    object ConvertScreen : Routes("/convert_screen")
    object CurrenciesScreen : Routes("/currencies_screen")
    object HistoryScreen : Routes("/history_screen")
}