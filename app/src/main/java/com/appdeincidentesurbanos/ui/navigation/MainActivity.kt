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
                        // Tela de Login
                        composable("login") {
                            LoginScreen(
                                onLoginSuccess = {
                                    navController.navigate("dashboard") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                },
                                onNavigateToRegister = {
                                    navController.navigate("register")
                                }
                            )
                        }

                        // Tela de Cadastro
                        composable("register") {
                            RegisterScreen(
                                onRegisterSuccess = {
                                    // Após cadastro, volta para Login
                                    navController.popBackStack()
                                },
                                onNavigateToLogin = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        // Tela Home (Dashboard)
                        composable("dashboard") {
                            DashboardScreen(
                                userName = "Usuário", // futuramente vem do banco
                                onLogout = {
                                    navController.navigate("login") {
                                        popUpTo("dashboard") { inclusive = true }
                                    }
                                }
                            )
                        }

                        // Outras telas que virão depois
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
                    }
                }
            }
        }
    }
}
