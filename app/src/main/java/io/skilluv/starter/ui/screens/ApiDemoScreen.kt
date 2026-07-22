package io.skilluv.starter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.skilluv.starter.R
import io.skilluv.starter.data.api.GitHubApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ApiDemoState {
    data object Idle : ApiDemoState
    data object Loading : ApiDemoState
    data class Loaded(val stars: Int) : ApiDemoState
    data class Error(val message: String) : ApiDemoState
}

@HiltViewModel
class ApiDemoViewModel @Inject constructor(private val api: GitHubApi) : ViewModel() {
    private val _state = MutableStateFlow<ApiDemoState>(ApiDemoState.Idle)
    val state: StateFlow<ApiDemoState> = _state.asStateFlow()

    fun fetch(repo: String = "JetBrains/kotlin") {
        _state.value = ApiDemoState.Loading
        viewModelScope.launch {
            runCatching { api.repo(repo) }
                .onSuccess { _state.value = ApiDemoState.Loaded(it.stargazersCount) }
                .onFailure { _state.value = ApiDemoState.Error(it.message ?: "unknown") }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApiDemoScreen(vm: ApiDemoViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()
    Scaffold(topBar = { TopAppBar(title = { Text(stringResource(R.string.api_demo)) }) }) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Fetches github.com/JetBrains/kotlin via Ktor + Hilt.", style = MaterialTheme.typography.bodyMedium)
            Button(onClick = { vm.fetch() }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.fetch))
            }
            when (val s = state) {
                ApiDemoState.Idle -> {}
                ApiDemoState.Loading -> CircularProgressIndicator()
                is ApiDemoState.Loaded -> Text("⭐ ${s.stars}", style = MaterialTheme.typography.headlineMedium)
                is ApiDemoState.Error -> Text("Error: ${s.message}", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
