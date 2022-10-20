package com.ptk.mmexchangerates.view.ui_resources.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ptk.mmexchangerates.viewmodel.MMExchangeRatesViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RowScope.MyDropDown(viewModel: MMExchangeRatesViewModel, list: ArrayList<String>) {


    var selectedItem by remember {
        mutableStateOf(list[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // the box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        Modifier.weight(1f)

    ) {

        // text field
        OutlinedTextField(
            value = selectedItem,
            readOnly = true,
            onValueChange = {},
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    viewModel.setSelectedCurrency(selectedItem)
                    expanded = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }
}