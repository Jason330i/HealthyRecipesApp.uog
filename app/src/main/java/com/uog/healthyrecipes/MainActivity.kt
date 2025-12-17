package com.uog.healthyrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.uog.healthyrecipes.ui.theme.HealthyRecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            HealthyRecipesTheme(darkTheme = darkTheme) {
                NavHost(
                    navController = navController,
                    startDestination = "list"
                ) {
                    composable("list") {
                        RecipeListScreen(
                            navController = navController,
                            darkTheme = darkTheme,
                            onToggleTheme = { darkTheme = it }
                        )
                    }

                    composable(
                        route = "recipe/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: 1
                        RecipeScreen(
                            navController = navController,
                            recipeId = id,
                            darkTheme = darkTheme,
                            onToggleTheme = { darkTheme = it }
                        )
                    }
                }
            }
        }
    }
}







