package com.example.minesweeper.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

const val maxHeight = 40
const val maxWidth = 40

class HomeViewModel : ViewModel() {
    var heightSliderPos by mutableFloatStateOf(0f)
    val height
        get() = (heightSliderPos* maxHeight).toInt()

    var widthSliderPos by mutableFloatStateOf(0f)
    val width
        get() = (widthSliderPos* maxWidth).toInt()

    var mineAmountSliderPos by mutableFloatStateOf(0f)
    val mineAmount
        get() = (mineAmountSliderPos*width*height).toInt()

    fun restrictStartButton(): Boolean {
        return (mineAmount > 0 && mineAmountSliderPos < 1f && height > 0 && width > 0)
    }
}