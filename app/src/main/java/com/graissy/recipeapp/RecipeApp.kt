package com.graissy.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// (7) *** We make a Recipe App  ***
// Then we put it in 'MainActivity' and we create a 'navController' in 'setContent{}'
// Before we run the App we add 'parcelize' plugin and we make the data class 'Category' parcelable
@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(route = Screen.RecipeScreen.route){
           // Here we go to 'RecipeScreen' and add 'viewstate' property
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                // This is responsible for passing data from the current screen to the detail screen.
                // It utilizes the 'savedStateHandle', which is a component of the Compose Navigation Framework.

                // 'navController.currentBackStackEntry?' :  retrieves the current navigation Backstack entry which represents
                // the current screen state within the navigation graph
                // 'savedStateHandle?' : It is a mechanism for passing data between different screens using the Jetpack Compose Navigation.
                // It provides a way to store data that need to be passed to the next screen
                // '.set("cat", it)' : This method sets a key value pair in 'savedStateHandle' Key: cat, Value: it
                // The key is used s a reference to retrieve the data on the detail screen.

                // Basically this is where we're storing the category
                // In the Detail Screen we need to retrieve this information
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }

        composable(route = Screen.DetailScreen.route){
            // We get the category from 'savedStateHandle' from above
            // If 'cat' is empty we create an empty category
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("", "", "", "")
            // Now we need to pass that category to the Category Detail Screen
            CategoryDetailScreen(category = category)
        }

    }
}


