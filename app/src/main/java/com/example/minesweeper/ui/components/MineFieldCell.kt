package com.example.minesweeper.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minesweeper.ui.screens.game.MineField
import com.example.minesweeper.ui.screens.game.MineFieldTypes
import com.example.minesweeper.ui.screens.game.Selectors

@Composable
fun MineFieldCell(mineField: MineField, selector: Selectors) {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier
            .aspectRatio(1f)
            .padding(1.dp),
        onClick = {
            if (mineField.isExposed)
                return@Surface

            if (selector == Selectors.MINE && !mineField.isFlagged)
                mineField.isExposed = true

            else if (selector == Selectors.FLAG) // redundant but it's for clarity
                mineField.isFlagged = !mineField.isFlagged
        }
    ) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (mineField.isExposed) {
                when (mineField.type) {
                    MineFieldTypes.NUMBER -> Text("${mineField.adjacentMines}")
                    MineFieldTypes.BOMB -> Text("Bomb") // there's gonna be an image for that
                }
            }

            else if (mineField.isFlagged)
                Text("Flagged") // there's gonna be an image for that too
        }
    }
}