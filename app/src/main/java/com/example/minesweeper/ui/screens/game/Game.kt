package com.example.minesweeper.ui.screens.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.minesweeper.R
import com.example.minesweeper.ui.components.GenerateMineField
import com.example.minesweeper.ui.screens.Screens

@Composable
fun Game(innerPadding: PaddingValues, navController: NavHostController) {
    var selector by rememberSaveable { mutableStateOf(Selectors.MINE) }

    val gameViewModel = viewModel<GameViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GameViewModel(Pos(10, 10),10) as T
            }
        }
    ) // I stole that part of the code from this guy: https://www.youtube.com/watch?v=9sqvBydNJSg

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Go back arrow
            Surface(
                shape = RoundedCornerShape(100),
                color = Color.Gray,
                onClick = { navController.navigate(Screens.Home.route) }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back",
                    modifier = Modifier.size(50.dp))
            }

            // Selector
            Surface(
                modifier = Modifier.size(50.dp),
                onClick = { selector = if (selector != Selectors.FLAG) Selectors.FLAG else Selectors.MINE }
            ) {
                Image(
                    painter = painterResource(
                    id = if (selector == Selectors.FLAG) R.drawable.flag else R.drawable.mine),
                    contentDescription = "Selector",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        GenerateMineField(gameViewModel, selector)
    }
}