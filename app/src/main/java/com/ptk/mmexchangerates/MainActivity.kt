@file:OptIn(ExperimentalAnimationApi::class)

package com.ptk.mmexchangerates

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ptk.mmexchangerates.view.ui_resources.composables.DrawerBody
import com.ptk.mmexchangerates.view.ui_resources.composables.DrawerHeader
import com.ptk.mmexchangerates.view.ui_resources.composables.TopBar
import com.ptk.mmexchangerates.view.ui_resources.navigator.NavGraph
import com.ptk.mmexchangerates.view.ui_resources.theme.MMExchangeRatesTheme
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MMExchangeRatesTheme {
                MainComposable()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainComposable(viewModel: MMExchangeRatesViewModel = hiltViewModel()) {
        val navController = rememberAnimatedNavController()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val title: String by viewModel.screenTitle.collectAsState()

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(
                    title,
                    navController = navController,
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            drawerContent = {
                DrawerHeader()
                DrawerBody(navController = navController, closeNavDrawer = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                })
            }
        ) {
            NavGraph(viewModel, navController)
        }
    }
}
