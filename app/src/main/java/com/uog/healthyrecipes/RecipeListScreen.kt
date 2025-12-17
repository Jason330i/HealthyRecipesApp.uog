package com.uog.healthyrecipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uog.healthyrecipes.data.Recipe
import com.uog.healthyrecipes.data.RecipeData
import com.uog.healthyrecipes.ui.theme.HealthyRecipesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    navController: NavHostController,
    darkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Choose a Recipe") },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        Text(if (darkTheme) "Dark" else "Light")
                        Spacer(Modifier.width(8.dp))
                        Switch(
                            checked = darkTheme,
                            onCheckedChange = onToggleTheme
                        )
                    }
                }
            )
        }
    ) { padding ->
        RecipeListContent(
            recipes = RecipeData.recipes,
            onRecipeClick = { recipe ->
                navController.navigate("recipe/${recipe.id}")
            },
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        )
    }
}

@Composable
fun RecipeListContent(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(recipes) { recipe ->
            RecipeListItem(recipe = recipe, onClick = { onRecipeClick(recipe) })
        }
    }
}

@Composable
fun RecipeListItem(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(recipe.title, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                Text(recipe.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

/** IMPORTANT: keep this exact name for PreviewActivity */
@Preview(showBackground = true)
@Composable
fun PreviewRecipeListScreen() {
    HealthyRecipesTheme(darkTheme = false) {
        RecipeListContent(
            recipes = RecipeData.recipes,
            onRecipeClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeListScreenDark() {
    HealthyRecipesTheme(darkTheme = true) {
        RecipeListContent(
            recipes = RecipeData.recipes,
            onRecipeClick = {}
        )
    }
}
