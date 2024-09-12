package com.example.minesweeper.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.minesweeper.ui.screens.Screens

@Composable
fun Home(innerPadding: PaddingValues, navController: NavController) {
    Row(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Button(onClick = { navController.navigate(Screens.Game.route) }) {
            Text("Start")
        }
    }
}