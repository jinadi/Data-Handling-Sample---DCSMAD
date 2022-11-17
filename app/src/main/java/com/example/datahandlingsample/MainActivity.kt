package com.example.datahandlingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.datahandlingsample.data.UserDatabase
import com.example.datahandlingsample.data.entities.User
import com.example.datahandlingsample.data.repositories.UserRepository
import com.example.datahandlingsample.ui.LoginViewModel
import com.example.datahandlingsample.ui.login.LoginScreen
import com.example.datahandlingsample.ui.main.MainScreen
import com.example.datahandlingsample.ui.navbar.BottomNavItem
import com.example.datahandlingsample.ui.navbar.BottomNavigationBar
import com.example.datahandlingsample.ui.navbar.Navigation
import com.example.datahandlingsample.ui.theme.DataHandlingSampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataHandlingSampleTheme {

                val viewModel = LoginViewModel(UserRepository(UserDatabase.getInstance(this)))
                //LoginScreen(viewModel, this)
                // MainScreen(loginViewModel = viewModel)

                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Add New",
                                    route = "addUser",
                                    icon = Icons.Default.Add
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            })
                    }
                ) {
                    Navigation(navController = navController, loginViewModel = viewModel , context = this)
                }


            }
        }

        /*lifecycleScope.launch{
            val dao = UserDatabase.getInstance(applicationContext).getUserDaos()

            val users = listOf(
                User(firstName = "Mike", lastName = "Litoris"),
                User(firstName = "Jack", lastName = "Goff"),
                User(firstName = "Chris P.", lastName = "Chicken")

            )
            users.forEach { dao.insertAll(it) }
        }*/


    }
}

