package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ptk.mmexchangerates.R
import com.ptk.mmexchangerates.view.ui_resources.composables.list_item.DrawerMenuItem
import com.ptk.mmexchangerates.view.ui_resources.navigator.Routes

@Composable
fun DrawerBody(navController: NavHostController?, closeNavDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_baseline_currency_exchange_32,
            text = "Exchange Rates",
            onItemClick = {
                navController?.navigate(Routes.ExchangeRatesScreen.route)
                closeNavDrawer()
            }
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_baseline_compare_arrows_32,
            text = "Convert",
            onItemClick = {
                navController?.navigate(Routes.ConvertScreen.route)
                closeNavDrawer()
            }
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.currencies_svgrepo_com,
            text = "Currencies",
            onItemClick = {
                navController?.navigate(Routes.CurrenciesScreen.route)
                closeNavDrawer()
            }
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_baseline_history_32,
            text = "History",
            onItemClick = {
                navController?.navigate(Routes.HistoryScreen.route)
                closeNavDrawer()
            }
        )
    }
}