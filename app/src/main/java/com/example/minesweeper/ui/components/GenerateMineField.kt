package com.example.minesweeper.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.minesweeper.ui.screens.game.GameViewModel
import com.example.minesweeper.ui.screens.game.Selectors

@Composable
fun GenerateMineField(gameViewModel: GameViewModel, selector: Selectors) {
    Column(modifier = Modifier.fillMaxSize()) {
        for (row in 0..<gameViewModel.size.row) {
            Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                for (col in 0..<gameViewModel.size.col) {
                    MineFieldSquare(gameViewModel.board[row][col], selector,
                        Modifier
                            .fillMaxSize()
                            .weight(1f)) // Doesn't generate squares
                }
            }
        }
    }
}