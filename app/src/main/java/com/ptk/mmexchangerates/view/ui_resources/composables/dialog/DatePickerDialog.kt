package com.ptk.mmexchangerates.view.ui_resources.composables.dialog

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel
import java.util.*

@Composable
fun MyDatePicker(
    viewModel: MMExchangeRatesViewModel,
): DatePickerDialog {
    val mCalendar = Calendar.getInstance()

    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    return DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            viewModel.setDate("$selectedDayOfMonth-${selectedMonth + 1}-$selectedYear")
            viewModel.getHistory("$selectedDayOfMonth-${selectedMonth + 1}-$selectedYear")

        },
        mYear,
        mMonth,
        mDay
    )
}