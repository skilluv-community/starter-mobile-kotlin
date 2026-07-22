package io.skilluv.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.skilluv.starter.ui.screens.ApiDemoScreen
import io.skilluv.starter.ui.screens.CounterScreen
import io.skilluv.starter.ui.screens.HomeScreen
import io.skilluv.starter.ui.screens.SettingsScreen
import io.skilluv.starter.ui.theme.SkilluvTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkilluvTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "home") {
                    composable("home") { HomeScreen(nav) }
                    composable("counter") { CounterScreen() }
                    composable("api") { ApiDemoScreen() }
                    composable("settings") { SettingsScreen() }
                }
            }
        }
    }
}
