package com.example.minesweeper.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.minesweeper.ui.screens.game.GameViewModel
import com.example.minesweeper.ui.screens.game.Selectors

@Composable
fun GenerateMineField(gameViewModel: GameViewModel, selector: Selectors) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(gameViewModel.size.col)
    ) {
        items(items = gameViewModel.board.flatten()) { cell ->
                MineFieldCell(cell, selector)
        }
    }
}