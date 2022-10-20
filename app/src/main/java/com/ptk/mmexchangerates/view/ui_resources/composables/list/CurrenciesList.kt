package com.ptk.mmexchangerates.view.ui_resources.composables.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ptk.mmexchangerates.model.dto.CurrencyModel
import com.ptk.mmexchangerates.view.ui_resources.composables.list_item.ExchangeRatesListItem

@Composable
fun CurrenciesList(currencyList: ArrayList<CurrencyModel>) {
    LazyColumn(modifier = Modifier.padding(vertical = 16.dp)) {
        itemsIndexed(items = currencyList) { index, currencyModel ->
            ExchangeRatesListItem(
                firstPosition = index == 0,
                isCurrency = true,
                currencyModel = currencyModel
            )
            if (index == 0)
                Divider(color = Color.Black)

        }
    }
}