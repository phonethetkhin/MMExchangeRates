package com.ptk.mmexchangerates.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.mmexchangerates.model.ExchangeRatesModel
import com.ptk.mmexchangerates.view.ui_resources.composables.dialog.LoadingDialog
import com.ptk.mmexchangerates.view.ui_resources.composables.list.RatesList
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@Composable
fun ExchangeRatesScreen(
    viewModel: MMExchangeRatesViewModel = hiltViewModel(),
) {
    val uiStates by viewModel.uiStates.collectAsState()

    LaunchedEffect("") {
        viewModel.getLatestExchangeRates()
    }
    ExchangeRatesScreenContent(uiStates)
    LoadingDialog(showDialog = uiStates.showLoadingDialog)

}


@Composable
fun ExchangeRatesScreenContent(
    uiStates: UIStates,
) {
    uiStates.rates?.let { rateList ->
        handleCurrencyPosition(rateList)
        RatesList(rateList = rateList)
    }
}

fun handleCurrencyPosition(rateList: ArrayList<ExchangeRatesModel>) {
    val sgdItem = rateList.find { it.currency == "SGD" }!!
    rateList.remove(sgdItem)
    rateList.add(1, sgdItem)

    val thbItem = rateList.find { it.currency == "THB" }!!
    rateList.remove(thbItem)
    rateList.add(2, thbItem)

    val eurItem = rateList.find { it.currency == "EUR" }!!
    rateList.remove(eurItem)
    rateList.add(3, eurItem)

    val gbpItem = rateList.find { it.currency == "GBP" }!!
    rateList.remove(gbpItem)
    rateList.add(4, gbpItem)

    val cnyItem = rateList.find { it.currency == "CNY" }!!
    rateList.remove(cnyItem)
    rateList.add(5, cnyItem)

    val krwItem = rateList.find { it.currency == "KRW" }!!
    rateList.remove(krwItem)
    rateList.add(6, krwItem)

    val jpyItem = rateList.find { it.currency == "JPY" }!!
    rateList.remove(jpyItem)
    rateList.add(7, jpyItem)
}

