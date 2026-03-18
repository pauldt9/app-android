package com.example.firstapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.screens.LoginScreen
import com.example.firstapp.screens.MainScreen
import com.example.firstapp.screens.SignUpScreen
import com.example.firstapp.screens.WelcomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController() // Screen controller

    // This is where routes (screens) are defined
    NavHost(navController, startDestination = "main"){
        composable("login"){
            LoginScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }
        composable("welcome"){
            WelcomeScreen(navController)
        }
        composable("main"){
            MainScreen(navController)
        }
    }
}