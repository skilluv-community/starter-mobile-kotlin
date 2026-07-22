package io.skilluv.starter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.skilluv.starter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(stringResource(R.string.tagline), style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            Button(onClick = { nav.navigate("counter") }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.counter_title))
            }
            Button(onClick = { nav.navigate("api") }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.api_demo))
            }
            OutlinedButton(onClick = { nav.navigate("settings") }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.settings))
            }
        }
    }
}
