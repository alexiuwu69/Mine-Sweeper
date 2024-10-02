package com.example.minesweeper.ui.screens.game

import androidx.lifecycle.ViewModel

data class Pos(val row: Int, val col: Int)

class GameViewModel(val size: Pos, private val numOfMines: Int) : ViewModel() {
    val board = Array(size.row) { Array(size.col) { MineField() } }
    private val adjacentSquares = listOf(
        Pos(1, 0), // top
        Pos(0, 1), // right
        Pos(-1, 0), // bottom
        Pos(0, -1)) // left

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

                board[pos.row + rowIncrement][pos.col + colIncrement].adjacentMines++
            }
        }
    }

    fun exposeEmptyAdjacentSquares(mineField: MineField) {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (mineField === board[row][col])
                    exposeEmptyAdjacentSquares(row, col)
            }
        }
    }

    private fun exposeEmptyAdjacentSquares(row: Int, col: Int) {
        for (pos in adjacentSquares) {
            val newRow = row + pos.row
            val newCol = col + pos.col

            if (newRow < 0 || newRow >= size.row)
                continue

            if (newCol < 0 || newCol >= size.col)
                continue
            //avoiding index out of bounce

            val square = board[newRow][newCol]

            if (square.isExposed || square.isFlagged)
                continue

            square.isExposed = true
            if (square.adjacentMines == 0)
                exposeEmptyAdjacentSquares(newRow, newCol)
        }
    }
}