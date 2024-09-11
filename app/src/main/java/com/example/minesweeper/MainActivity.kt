package com.example.minesweeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minesweeper.ui.screens.Screens
import com.example.minesweeper.ui.screens.game.Game
import com.example.minesweeper.ui.screens.home.Home
import com.example.minesweeper.ui.theme.MineSweeperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MineSweeperTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(navController, startDestination = Screens.Home.route) {
                        composable(Screens.Home.route) {
                            Home(innerPadding, navController)
                        }

                        composable(Screens.Game.route) {
                            Game(innerPadding, navController)
                        }
                    }
                }
            }
        }
    }
}