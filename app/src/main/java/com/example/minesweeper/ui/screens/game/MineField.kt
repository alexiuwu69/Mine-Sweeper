package com.example.minesweeper.ui.screens.game

class MineField(var type: MineFieldTypes, var adjacentMines: Int) {
    var isFlagged = false
    var isExposed = false
}