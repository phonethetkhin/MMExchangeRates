package com.ptk.mmexchangerates.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.mmexchangerates.view.ui_resources.composables.list.CurrenciesList
import com.ptk.mmexchangerates.view.ui_resources.composables.dialog.LoadingDialog
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@Composable
fun CurrenciesScreen(viewModel: MMExchangeRatesViewModel = hiltViewModel()) {
    LaunchedEffect("") {
        viewModel.getCurrencies()
    }
    val uiStates by viewModel.uiStates.collectAsState()

    LaunchedEffect("") {
        viewModel.getLatestExchangeRates()
    }
    CurrenciesScreenContent(uiStates)
    LoadingDialog(showDialog = uiStates.showLoadingDialog)
}


@Composable
fun CurrenciesScreenContent(uiStates: UIStates) {
    uiStates.currencies?.let { currencyList ->
        CurrenciesList(currencyList = currencyList)
    }
}

