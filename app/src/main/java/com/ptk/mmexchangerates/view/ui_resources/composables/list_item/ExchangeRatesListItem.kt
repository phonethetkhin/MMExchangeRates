package com.ptk.mmexchangerates.view.ui_resources.composables.list_item

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ptk.mmexchangerates.model.ExchangeRatesModel
import com.ptk.mmexchangerates.model.dto.CurrencyModel
import com.ptk.mmexchangerates.view.ui_resources.theme.Purple500
import com.ptk.mmexchangerates.view.ui_resources.theme.Teal200

@Composable
fun ExchangeRatesListItem(
    isCurrency: Boolean = false,
    firstPosition: Boolean,
    exchangeRatesModel: ExchangeRatesModel? = null,
    currencyModel: CurrencyModel? = null
) {
    Card(
        backgroundColor = if (firstPosition) Teal200 else Purple500,
        modifier = Modifier.padding(
            top = if (firstPosition) 0.dp else 16.dp,
            start = 16.dp,
            end = 16.dp,
            bottom = if (firstPosition) 16.dp else 0.dp,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MyText(
                1f,
                if (isCurrency) currencyModel!!.shortName else "1 ${exchangeRatesModel!!.currency}"
            )
            MyText(1f, "=")
            MyText(2f, if (isCurrency) currencyModel!!.longName else exchangeRatesModel!!.rates)

        }

    }
}

@Composable
fun RowScope.MyText(weight: Float, text: String) {
    Text(
        text,
        Modifier
            .weight(weight)
            .padding(horizontal = 16.dp), fontWeight = FontWeight.ExtraBold
    )
}