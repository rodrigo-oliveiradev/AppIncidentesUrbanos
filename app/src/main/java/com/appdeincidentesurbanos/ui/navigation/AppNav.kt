package com.appdeincidentesurbanos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appdeincidentesurbanos.ui.dashboard.DashboardScreen
import com.appdeincidentesurbanos.ui.form.IncidentFormScreen
import com.appdeincidentesurbanos.ui.incidents.IncidentsScreen
import com.appdeincidentesurbanos.ui.login.LoginScreen

object Routes {
    const val LOGIN = "login"
    const val INCIDENTS = "incidents"
    const val INCIDENT_FORM = "incident_form"
    const val DASHBOARD = "dashboard"
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.LOGIN) {

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.INCIDENTS) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.INCIDENTS) {
            IncidentsScreen(
                onAddClick = { navController.navigate(Routes.INCIDENT_FORM) },
                onDashboardClick = { navController.navigate(Routes.DASHBOARD) }
            )
        }

        composable(Routes.INCIDENT_FORM) {
            IncidentFormScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.DASHBOARD) {
            DashboardScreen(onBack = { navController.popBackStack() })
        }
    }
}
