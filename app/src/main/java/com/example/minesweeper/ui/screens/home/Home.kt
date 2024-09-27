package com.example.minesweeper.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.minesweeper.ui.components.GenerateSlider
import com.example.minesweeper.ui.screens.Screens

@Composable
fun Home(innerPadding: PaddingValues, navController: NavController, viewModel: HomeViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Button(
            enabled = viewModel.restrictStartButton(),
            onClick = { navController.navigate(Screens.Game.route) }) {
            Text("Start")
        }

        GenerateSlider(
            "Width",
            viewModel.widthSliderPos,
            viewModel.width) { viewModel.widthSliderPos = it }

        GenerateSlider(
            "Height",
            viewModel.heightSliderPos,
            viewModel.height) { viewModel.heightSliderPos = it }

        GenerateSlider(
            "Mines",
            viewModel.mineAmountSliderPos,
            viewModel.mineAmount) { viewModel.mineAmountSliderPos = it }
    }
}