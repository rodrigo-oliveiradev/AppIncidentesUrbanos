package com.appdeincidentesurbanos.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appdeincidentesurbanos.ui.dashboard.DashboardScreen
import com.appdeincidentesurbanos.ui.form.IncidentFormScreen
import com.appdeincidentesurbanos.ui.incidents.IncidentsScreen
import com.appdeincidentesurbanos.ui.login.LoginScreen
import com.appdeincidentesurbanos.ui.login.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(
                                onLoginSuccess = {
                                    navController.navigate("incidents") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                },
                                onNavigateToRegister = {
                                    navController.navigate("register")
                                }
                            )
                        }

                        composable("register") {
                            RegisterScreen(
                                onRegisterSuccess = {
                                    navController.navigate("incidents") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                },
                                onNavigateToLogin = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        composable("incidents") {
                            IncidentsScreen(
                                onAddClick = { navController.navigate("form") },
                                onDashboardClick = { navController.navigate("dashboard") }
                            )
                        }

                        composable("form") {
                            IncidentFormScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("dashboard") {
                            DashboardScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
