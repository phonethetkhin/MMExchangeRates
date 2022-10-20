package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates

@Composable
fun ConvertedResultText(uiStates: UIStates) {
    Text(
        text = if (uiStates.convertedResult != null) "${uiStates.convertedResult} MMK" else "0 MMK",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}