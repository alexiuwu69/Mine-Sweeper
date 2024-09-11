package com.example.minesweeper.ui.screens

sealed class Screens(val route: String) {
    data object Home : Screens("Home")
    data object Game : Screens("Game")
}