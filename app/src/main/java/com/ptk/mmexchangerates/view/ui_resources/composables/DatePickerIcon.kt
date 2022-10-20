package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Today
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ptk.mmexchangerates.view.ui_resources.composables.dialog.MyDatePicker
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@Composable
fun DatePickerIcon(viewModel: MMExchangeRatesViewModel) {
    val myDatePicker = MyDatePicker(
        viewModel = viewModel
    )
    IconButton(
        onClick = { myDatePicker.show() },
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 8.dp),

        ) {
        Icon(
            imageVector = Icons.Filled.Today,
            contentDescription = "Get Date Icon",
            Modifier
                .width(40.dp)
                .height(40.dp)
        )
    }
}