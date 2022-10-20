package com.ptk.mmexchangerates.view.ui_resources.composables.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ptk.mmexchangerates.model.ExchangeRatesModel
import com.ptk.mmexchangerates.view.ui_resources.composables.list_item.ExchangeRatesListItem

@Composable
fun RatesList(rateList: ArrayList<ExchangeRatesModel>) {
    LazyColumn(modifier = Modifier.padding(vertical = 16.dp)) {
        itemsIndexed(items = rateList) { index, exchangeRatesModel ->
            ExchangeRatesListItem(
                firstPosition = index == 0,
                exchangeRatesModel = exchangeRatesModel
            )
            if (index == 0)
                Divider(color = Color.Black)

        }
    }
}