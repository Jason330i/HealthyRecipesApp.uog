package com.uog.healthyrecipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.uog.healthyrecipes.data.RecipeData
import com.uog.healthyrecipes.ui.theme.HealthyRecipesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(
    navController: NavHostController,
    recipeId: Int,
    darkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit
) {
    val recipe = RecipeData.getById(recipeId) ?: RecipeData.recipes.first()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text(recipe.title) },
                navigationIcon = {
                    TextButton(onClick = { navController.popBackStack() }) {
                        Text("Back")
                    }
                },
                actions = {
                    Row(modifier = Modifier.padding(end = 12.dp)) {
                        Switch(checked = darkTheme, onCheckedChange = onToggleTheme)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(Modifier.height(16.dp))
            Text(recipe.description, style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(16.dp))
            Text("Ingredients", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            recipe.ingredients.forEach { ingredient ->
                Text("• $ingredient", style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(4.dp))
            }

            Spacer(Modifier.height(16.dp))
            Text("Steps", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            recipe.steps.forEachIndexed { index, step ->
                Text("${index + 1}. $step", style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(6.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeScreen() {
    HealthyRecipesTheme(darkTheme = false) {
        RecipeScreen(
            navController = rememberNavController(),
            recipeId = 1,
            darkTheme = false,
            onToggleTheme = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeScreenDark() {
    HealthyRecipesTheme(darkTheme = true) {
        RecipeScreen(
            navController = rememberNavController(),
            recipeId = 1,
            darkTheme = true,
            onToggleTheme = {}
        )
    }
}
