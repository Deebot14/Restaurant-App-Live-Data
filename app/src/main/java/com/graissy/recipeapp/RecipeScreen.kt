package com.graissy.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

// (4) *** We make a Recipe Screen User Interface ***

// *(1)*
// We make the Recipe Screen
@Composable
fun RecipeScreen(modifier: Modifier = Modifier, navigateToDetail: (Category) -> Unit, // (5nav)
                 viewstate: MainViewModel.RecipeState){ // (6) for 'RecipeApp'
    // We need our View Model to get the data
    val recipeViewModel: MainViewModel = viewModel()
    // We need our 'categoriesState' to get the 'RecipeState' to know which categorie we've loaded
//    val viewstate by recipeViewModel.categoriesState
    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewstate.error != null -> {
                Text("ERROR OCCURRED")
            }
            else -> {
                // *(5)*
                // Display Categories
                CategoryScreen(categories = viewstate.list, navigateToDetail) // (5nav)
            }
        }
    }
}

// *(2)*
// We make a Categorie Screen
@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit){ // (5nav)
    // The way we display our categories is with a vertical grid
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        // *(4)*
        // List of items
        // For every single category item that we have available inside of your list of categories
        // pass that into a new 'CategoryItem'
        items(categories){
                category ->
            CategoryItem(category = category, navigateToDetail) // (5nav)
        }
    }
}

// *(3)*
// How each Item looks like
@Composable
fun CategoryItem(category: Category , navigateToDetail: (Category) -> Unit){ // (5nav)
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable { navigateToDetail(category) }, // (5nav)
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            // With the dependency we use 'rememberAsyncImagePainter' which loads
            // an image from the internet asynchronously and returns an AsyncImagePainter
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f) // be as wide as it is high
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
