package com.example.minesweeper.ui.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MineField {
    var type = MineFieldTypes.NUMBER
    var adjacentMines = 0
    var isFlagged by mutableStateOf(false)
    var isExposed by mutableStateOf(false)
}