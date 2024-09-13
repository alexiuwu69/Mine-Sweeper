package com.example.minesweeper.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.minesweeper.ui.components.GenerateMineField
import com.example.minesweeper.ui.screens.Screens

@Composable
fun Game(innerPadding: PaddingValues, navController: NavHostController) {
    var selector by rememberSaveable { mutableStateOf(Selectors.MINE) }
    val gameViewModel = GameViewModel(Pos(10, 10), 10)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                shape = RoundedCornerShape(100),
                color = Color.Gray,
                onClick = { navController.navigate(Screens.Home.route) }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back",
                    modifier = Modifier.size(50.dp))
            }

            Surface(shape = RoundedCornerShape(15),
                color = if (selector == Selectors.MINE) Color.Cyan else Color.Red,
                modifier = Modifier.size(50.dp),
                onClick = { selector = if (selector != Selectors.FLAG) Selectors.FLAG else Selectors.MINE })
            {} // changing the value of selector seems to reset the gameViewModel.. Which shouldn't happen
        }

        GenerateMineField(gameViewModel, selector)
    }
}