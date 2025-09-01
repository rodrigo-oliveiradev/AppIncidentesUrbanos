package com.appdeincidentesurbanos.ui.incidents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncidentsScreen(
    onAddClick: () -> Unit,
    onDashboardClick: () -> Unit
) {
    val mock = listOf("Assalto", "Acidente de trânsito", "Furto", "Buraco na via")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Incidentes") },
                actions = {
                    TextButton(onClick = onDashboardClick) { Text("Dashboard") }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) { Text("+") }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            items(mock) { item ->
                Card(Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                    ListItem(headlineContent = { Text(item) }, supportingContent = { Text("Categoria: exemplo") })
                }
            }
        }
    }
}
