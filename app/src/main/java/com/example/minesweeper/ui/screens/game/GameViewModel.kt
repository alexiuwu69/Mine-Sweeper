package com.example.minesweeper.ui.screens.game

import androidx.lifecycle.ViewModel

data class Pos(val row: Int, val col: Int)

class GameViewModel(val size: Pos, val numOfMines: Int) : ViewModel() {
    val board = Array(size.row) { Array(size.col) { MineField(MineFieldTypes.NUMBER, 0) } }

    init {
        placeMines()
    }

    private fun placeMines() {
        for (i in 0..<numOfMines) {
            var minePos: Pos
            do {
                minePos = Pos((0..<size.row).random(), (0..<size.col).random())
            } while (board[minePos.row][minePos.col].type == MineFieldTypes.BOMB)

            board[minePos.row][minePos.col].type = MineFieldTypes.BOMB
            increaseAdjacentBoardNumbers(minePos)
        }
    }

    private fun increaseAdjacentBoardNumbers(pos: Pos) {
        for (rowIncrement in -1..1) {
            if (pos.row + rowIncrement < 0 || pos.row + rowIncrement >= size.row)
                continue

            for (colIncrement in -1..1) {
                if (pos.col + colIncrement < 0 || pos.col + colIncrement >= size.col)
                    continue

                board[pos.row][pos.col].adjacentMines++
            }
        }
    }
}