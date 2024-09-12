package com.example.minesweeper.ui.screens.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.minesweeper.ui.components.GenerateMineField
import com.example.minesweeper.ui.components.MineFieldSquare

@Composable
fun Game(innerPadding: PaddingValues, navController: NavHostController) {
    val gameViewModel = GameViewModel(Pos(4, 4), 10)
    var selector = rememberSaveable { Selectors.MINE }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
        Surface(shape = RoundedCornerShape(15),
            color = Color.Cyan,
            onClick = { selector = if (selector == Selectors.MINE) Selectors.FLAG else Selectors.MINE }) { // probably disgusting code
        }

        GenerateMineField(gameViewModel, selector)
    }
}

