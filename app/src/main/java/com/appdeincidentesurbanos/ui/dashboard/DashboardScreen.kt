package com.appdeincidentesurbanos.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    userName: String = "Usuário",
    onLogout: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Urban Incidents · Home") },
                actions = {
                    TextButton(onClick = onLogout) {
                        Text("Sair")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bem-vindo, $userName 👋",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { /* TODO: ir para lista de incidentes */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Meus Incidentes")
            }

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { /* TODO: abrir estatísticas */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dashboard de Estatísticas")
            }
        }
    }
}