package com.example.datahandlingsample.ui.navbar

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.datahandlingsample.ui.LoginViewModel
import com.example.datahandlingsample.ui.login.LoginScreen
import com.example.datahandlingsample.ui.main.MainScreen

@Composable
fun Navigation(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    context: Context
) {
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            MainScreen(loginViewModel = loginViewModel)
        }
        composable("addUser"){
            LoginScreen(context = context, loginViewModel = loginViewModel)
        }
    }
}