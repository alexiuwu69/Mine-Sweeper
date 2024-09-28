package com.example.minesweeper.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.minesweeper.R
import com.example.minesweeper.ui.screens.game.MineField
import com.example.minesweeper.ui.screens.game.MineFieldTypes
import com.example.minesweeper.ui.screens.game.Selectors

@Composable
fun MineFieldCell(mineField: MineField, selector: Selectors, exposeEmptyAdjacentSquares: (MineField) -> Unit) {
    Surface(
        modifier = Modifier
            .aspectRatio(1f),
        onClick = {
            if (mineField.isExposed)
                return@Surface

            if (selector == Selectors.MINE && !mineField.isFlagged)
                mineField.isExposed = true

            if (mineField.adjacentMines == 0 && !mineField.isFlagged)
                exposeEmptyAdjacentSquares(mineField)

            else if (selector == Selectors.FLAG)
                mineField.isFlagged = !mineField.isFlagged
        }
    ) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (mineField.isExposed) {
                when (mineField.type) {
                    MineFieldTypes.NUMBER -> Image(
                        painter = painterResource(id = getNumberTile(mineField.adjacentMines)),
                        contentDescription = "${mineField.adjacentMines}",
                        modifier = Modifier.fillMaxSize()
                    )

                    MineFieldTypes.BOMB -> Image(
                        painter = painterResource(id = R.drawable.mine),
                        contentDescription = "Mine",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            else if (mineField.isFlagged)
                Image(
                    painter = painterResource(id = R.drawable.flag),
                    contentDescription = "Flag",
                    modifier = Modifier.fillMaxSize()
                )

            else
                Image(
                    painter = painterResource(id = R.drawable.tile),
                    contentDescription = "Tile",
                    modifier = Modifier.fillMaxSize()
                )
        }
    }
}

private fun getNumberTile(adjacentMines: Int): Int {
    return when (adjacentMines) {
        0 -> R.drawable.tile_0
        1 -> R.drawable.tile_1
        2 -> R.drawable.tile_2
        3 -> R.drawable.tile_3
        4 -> R.drawable.tile_4
        5 -> R.drawable.tile_5
        6 -> R.drawable.tile_6
        7 -> R.drawable.tile_7
        8 -> R.drawable.tile_8
        else -> R.drawable.tile // won't happen tho
    }
}