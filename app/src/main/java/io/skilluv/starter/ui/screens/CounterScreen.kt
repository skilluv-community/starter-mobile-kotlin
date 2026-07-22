package io.skilluv.starter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.skilluv.starter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterScreen() {
    var count by remember { mutableIntStateOf(0) }
    Scaffold(topBar = { TopAppBar(title = { Text(stringResource(R.string.counter_title)) }) }) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Value: $count", style = MaterialTheme.typography.headlineSmall)
            Text("Doubled: ${count * 2}", style = MaterialTheme.typography.bodyMedium)
            Button(onClick = { count += 1 }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.increment))
            }
            OutlinedButton(onClick = { count -= 1 }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.decrement))
            }
            TextButton(onClick = { count = 0 }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.reset))
            }
        }
    }
}
