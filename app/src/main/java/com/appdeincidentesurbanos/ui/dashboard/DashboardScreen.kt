package com.appdeincidentesurbanos.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Voltar") } }
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Gráficos e estatísticas virão aqui")
            Spacer(Modifier.height(12.dp))
            Card(Modifier.fillMaxWidth()) {
                ListItem(headlineContent = { Text("Incidentes por categoria") },
                    supportingContent = { Text("Em breve") })
            }
        }
    }
}
