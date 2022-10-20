package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ptk.mmexchangerates.R
import com.ptk.mmexchangerates.view.ui_resources.theme.Purple500

@Composable
fun DrawerHeader() {
    Surface(color = Purple500, modifier = Modifier.height(200.dp)) {

        Column(
            modifier = Modifier
                .fillMaxWidth().padding(top= 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "CBM Exchange Rates", fontSize = 30.sp)
            Spacer(modifier = Modifier.padding(16.dp))
            Icon(
                painterResource(id = R.drawable.ic_baseline_currency_exchange_64),
                contentDescription = "Currency Exchange Icon"
            )
        }
    }
}