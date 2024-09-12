package com.example.minesweeper.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.minesweeper.ui.screens.game.MineField
import com.example.minesweeper.ui.screens.game.MineFieldTypes
import com.example.minesweeper.ui.screens.game.Selectors

@Composable
fun MineFieldSquare(mineField: MineField, selector: Selectors, modifier: Modifier) {
    Surface(
        modifier = modifier,
        onClick = {
            if (mineField.isExposed)
                return@Surface

            if (selector == Selectors.MINE)
                mineField.isExposed = true

            else
                mineField.isFlagged = true
        }
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            if (!mineField.isExposed)
                return@Row

            when (mineField.type) {
                MineFieldTypes.NUMBER -> Text("${mineField.adjacentMines}")
                MineFieldTypes.BOMB -> Text("Bomb") // there's gonna be an image for that
            }
        }
    }
}