package com.uog.healthyrecipes.data

import com.uog.healthyrecipes.R

object RecipeData {

    val recipes: List<Recipe> = listOf(
        Recipe(
            id = 1,
            title = "Avocado Toast",
            description = "Quick, healthy breakfast with good fats.",
            ingredients = listOf(
                "2 slices bread",
                "1 ripe avocado",
                "Salt and black pepper",
                "Lemon juice (optional)",
                "Chilli flakes (optional)"
            ),
            steps = listOf(
                "Toast the bread until golden.",
                "Mash avocado in a bowl with salt, pepper, and a squeeze of lemon.",
                "Spread avocado on toast.",
                "Finish with chilli flakes if you want a kick."
            ),
            imageResId = R.drawable.avocado_toast
        ),
        Recipe(
            id = 2,
            title = "Overnight Oats",
            description = "High fibre breakfast you prep in advance.",
            ingredients = listOf(
                "1/2 cup oats",
                "1/2–1 cup milk (or alternative)",
                "2 tbsp Greek yoghurt (optional)",
                "1 tsp honey (optional)",
                "Berries / banana"
            ),
            steps = listOf(
                "Add oats and milk into a jar/bowl.",
                "Stir in yoghurt and honey (optional).",
                "Cover and refrigerate overnight.",
                "In the morning, top with fruit and eat cold or warm it up."
            ),
            imageResId = R.drawable.overnight_oats
        ),
        Recipe(
            id = 3,
            title = "Chicken Tikka Masala (Light)",
            description = "High protein, lighter creamy sauce.",
            ingredients = listOf(
                "Chicken breast (cubed)",
                "Onion (chopped)",
                "Garlic (minced)",
                "Tikka/garam masala spice mix",
                "Chopped tomatoes",
                "Greek yoghurt (instead of heavy cream)",
                "Salt and pepper"
            ),
            steps = listOf(
                "Season chicken with spices, salt, and pepper.",
                "Pan-fry chicken until browned, then set aside.",
                "Cook onion and garlic until soft.",
                "Add tomatoes and spices, simmer 5–10 minutes.",
                "Stir in yoghurt on low heat (do not boil).",
                "Return chicken to the pan and simmer until cooked through."
            ),
            imageResId = R.drawable.chicken_tikka_masala
        ),
        Recipe(
            id = 4,
            title = "Spaghetti Carbonara",
            description = "Simple pasta with eggs, cheese, and black pepper.",
            ingredients = listOf(
                "Spaghetti",
                "Eggs",
                "Parmesan (or similar)",
                "Pancetta (or turkey bacon)",
                "Black pepper",
                "Salt"
            ),
            steps = listOf(
                "Boil spaghetti in salted water until al dente.",
                "Mix eggs and grated cheese in a bowl.",
                "Fry pancetta until crisp.",
                "Turn heat low, add drained pasta to pancetta.",
                "Remove pan from heat, stir in egg/cheese mix quickly.",
                "Add pepper and a splash of pasta water if needed."
            ),
            imageResId = R.drawable.spaghetti_carbonara
        )
    )

    fun getById(id: Int): Recipe? = recipes.firstOrNull { it.id == id }
}

