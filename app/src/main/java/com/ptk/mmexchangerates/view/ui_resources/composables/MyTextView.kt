package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ptk.mmexchangerates.view.ui_resources.theme.Purple500

@Composable
fun RowScope.MyTextView(selectedDate:String? = null) {
    Card(
        border = BorderStroke(2.dp, Purple500),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .weight(1f)
            .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
    ) {
        Text(
            selectedDate ?: "",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}