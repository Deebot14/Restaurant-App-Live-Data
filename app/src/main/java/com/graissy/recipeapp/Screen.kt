package com.graissy.recipeapp

// (6) *** After we add Navigation dependence we make a Screen class ***
// it takes care of individual routes
// 'sealed' classes ensure type safety by restricting types to be matched at compile time
// rather than runtime → they will match in the IDE before we click run
sealed class Screen (val route: String){
    object RecipeScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}