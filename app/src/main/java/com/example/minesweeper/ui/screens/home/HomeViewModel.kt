package com.example.minesweeper.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.core.util.toClosedRange
import androidx.core.util.toRange
import androidx.lifecycle.ViewModel
import kotlin.random.Random

const val maxHeight = 40
const val maxWidth = 40

class HomeViewModel : ViewModel() {
    var heightSliderPos by mutableFloatStateOf(0.25f)
    val height
        get() = (heightSliderPos * maxHeight).toInt()

    var widthSliderPos by mutableFloatStateOf(0.25f)
    val width
        get() = (widthSliderPos * maxWidth).toInt()

    var mineAmountSliderPos by mutableFloatStateOf(0.1f)
    val mineAmount
        get() = (mineAmountSliderPos * width * height).toInt()

    fun restrictStartButton(): Boolean {
        return (mineAmount > 0 && mineAmountSliderPos < 1f && height > 0 && width > 0)
    }

    fun randomizeBoardValues() {
        heightSliderPos = Random.nextFloat()
        widthSliderPos = Random.nextFloat()
        mineAmountSliderPos = Random.nextFloat()
    }
}