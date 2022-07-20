package com.example.psaweathertest.presentation.cities_list.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonComponent(
    radioOptions: List<String>,
    modifier: Modifier = Modifier,
    onOptionSelected: String.() -> Unit
) {

    val selectedOption = remember { mutableStateOf(radioOptions.getOrNull(0)) }
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = modifier
            .fillMaxWidth(),

        // below line is used for
        // specifying vertical arrangement.
        verticalArrangement = Arrangement.Center,


        ) {
        // we are displaying all our
        // radio buttons in column.
        Row {
            // below line is use to set data to
            // each radio button in columns.
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        // using modifier to add max
                        // width to our radio button.

                        // below method is use to add
                        // selectable to our radio button.
                        .selectable(
                            // this method is called when
                            // radio button is selected.
                            selected = (text == selectedOption.value),
                            // below method is called on
                            // clicking of radio button.
                            onClick = {
                                onOptionSelected(text)

                                selectedOption.value = text
                            }
                        )
                        // below line is use to add
                        // padding to radio button.
                        .padding(horizontal = 16.dp)

                ) {
                    // below line is use to get context.
                    val context = LocalContext.current

                    // below line is use to
                    // generate radio button
                    RadioButton(
                        // inside this method we are
                        // adding selected with a option.
                        selected = (text == selectedOption.value),
                        modifier = Modifier.padding(all = Dp(value = 8F)),
                        onClick = {
                            // inide on click method we are setting a
                            // selected option of our radio buttons.
                            onOptionSelected(text)
                            selectedOption.value = text
                            // after clicking a radio button
                            // we are displaying a toast message.

                        }
                    )
                    // below line is use to add
                    // text to our radio buttons.
                    Text(
                        text = text,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                }
            }
        }
    }
}