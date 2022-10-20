package com.ptk.mmexchangerates.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.mmexchangerates.view.ui_resources.composables.DatePickerIcon
import com.ptk.mmexchangerates.view.ui_resources.composables.MyTextView
import com.ptk.mmexchangerates.view.ui_resources.composables.NoResultText
import com.ptk.mmexchangerates.view.ui_resources.composables.dialog.LoadingDialog
import com.ptk.mmexchangerates.view.ui_resources.composables.list.RatesList
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel
import java.util.*

@Composable
fun HistoryScreen(viewModel: MMExchangeRatesViewModel = hiltViewModel()) {
    val uiStates by viewModel.uiStates.collectAsState()

    LaunchedEffect("") {
        fetchData(viewModel)
    }


    HistoryScreenContent(viewModel, uiStates)
    LoadingDialog(showDialog = uiStates.showLoadingDialog)

}


@Composable
fun HistoryScreenContent(
    viewModel: MMExchangeRatesViewModel,
    uiStates: UIStates,

    ) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MyTextView(uiStates.selectedDate)
            DatePickerIcon(viewModel)
        }
        if (uiStates.noResult) {
            NoResultText()
        } else {
            uiStates.rates?.let { rateList ->
                RatesList(rateList = rateList)
            }
        }
    }
}

fun fetchData(viewModel: MMExchangeRatesViewModel) {
    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    viewModel.setDate("$mDay-${mMonth + 1}-$mYear")
    viewModel.getHistory("$mDay-${mMonth + 1}-$mYear")
}


