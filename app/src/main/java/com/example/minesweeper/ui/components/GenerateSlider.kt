package com.example.minesweeper.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GenerateSlider(name: String, sliderPos: Float, displayNumber: Int, onValueChange: (Float) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(name)

        Slider(
            value = sliderPos,
            modifier = Modifier.weight(1f),
            onValueChange = { onValueChange(it) }
        )

        Text(displayNumber.toString())
    }
}