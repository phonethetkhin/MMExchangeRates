package com.ptk.mmexchangerates.view.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.mmexchangerates.util.showToast
import com.ptk.mmexchangerates.view.ui_resources.composables.ConvertedResultText
import com.ptk.mmexchangerates.view.ui_resources.composables.MyDropDown
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@Composable
fun ConvertScreen(viewModel: MMExchangeRatesViewModel = hiltViewModel()) {
    val uiStates by viewModel.uiStates.collectAsState()

    LaunchedEffect("") {
        viewModel.getLatestExchangeRates()
        viewModel.setSelectedCurrency("USD")
    }
    ConvertScreenContent(viewModel, uiStates)
}


@Composable
fun ConvertScreenContent(viewModel: MMExchangeRatesViewModel, uiStates: UIStates) {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
    ) {
        val context = LocalContext.current
        DropDownColumn(viewModel, uiStates)
        BottomColumn(context, uiStates, viewModel)
    }
}

@Composable
fun DropDownColumn(viewModel: MMExchangeRatesViewModel, uiStates: UIStates) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            uiStates.rates?.let { rateList ->
                handleCurrencyPosition(rateList)

                val list = rateList.map { it.currency }.toCollection(ArrayList())
                MyDropDown(viewModel, list)
                Spacer(modifier = Modifier.width(16.dp))
                MyDropDown(viewModel, arrayListOf("MMK"))

            }
        }
    }
}

@Composable
fun ColumnScope.BottomColumn(
    context: Context,
    uiStates: UIStates,
    viewModel: MMExchangeRatesViewModel
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ConvertedResultText(uiStates = uiStates)
        Spacer(modifier = Modifier.height(32.dp))
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter Amount") },
            onValueChange = {
                text = it
            }
        )
        Button(onClick = { calculateConversion(viewModel, uiStates, context, text) }) {
            Text("Convert")
        }
    }
}

fun calculateConversion(
    viewModel: MMExchangeRatesViewModel,
    uiStates: UIStates,
    context: Context,
    text: String
) {
    if (text.trim().isEmpty()) {
        context.showToast("Please Enter Amount to Convert !!!")
    } else {
        uiStates.rates?.let { rateList ->
            try {
                val rate = rateList.find { it.currency == uiStates.selectedCurrency }?.rates
                rate?.let {
                    val result = rate.replace(",", "").toDouble() * text.toDouble()
                    viewModel.setResult(result.toString())
                }
            } catch (e: Exception) {
                when (e) {
                    is java.lang.NumberFormatException -> context.showToast("Amount should be number")
                    else -> {}
                }
            }

        }
    }
}


