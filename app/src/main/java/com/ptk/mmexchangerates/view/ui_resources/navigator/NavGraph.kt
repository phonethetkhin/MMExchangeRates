@file:OptIn(ExperimentalAnimationApi::class)

package com.ptk.mmexchangerates.view.ui_resources.navigator

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.ptk.mmexchangerates.view.screens.ConvertScreen
import com.ptk.mmexchangerates.view.screens.CurrenciesScreen
import com.ptk.mmexchangerates.view.screens.ExchangeRatesScreen
import com.ptk.mmexchangerates.view.screens.HistoryScreen
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@Composable
fun NavGraph(viewModel: MMExchangeRatesViewModel, navController: NavHostController) {
    AnimatedNavHost(navController = navController,
        startDestination = Routes.ExchangeRatesScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        composable(route = Routes.ExchangeRatesScreen.route) {
            viewModel.setTitle("Exchange Rates")
            ExchangeRatesScreen()
        }
        composable(route = Routes.ConvertScreen.route) {
            viewModel.setTitle("Convert")
            ConvertScreen()
        }
        composable(route = Routes.CurrenciesScreen.route) {
            viewModel.setTitle("Currencies")
            CurrenciesScreen()
        }
        composable(route = Routes.HistoryScreen.route) {
            viewModel.setTitle("History")
            HistoryScreen()
        }
    }
}