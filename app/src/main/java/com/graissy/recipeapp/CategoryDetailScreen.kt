package com.graissy.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

// (5) *** We make a Category Detail Screen ***
// After finishing 'Navigation' we can now navigate to the Detail Screen
// (5nav) After we finish the function we go and modify 'CategoryItem', 'CategoryScreen', and
// 'RecipeScreen' in 'RecipeScreen.kt' and 'MainActivity'
@Composable
fun CategoryDetailScreen(category: Category){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        // Title
        Text(text = category.strCategory, textAlign = TextAlign.Center)

        // Image
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            modifier = Modifier
                .wrapContentSize() // take as much space as it needs
                .aspectRatio(1f)
        )

        // Description
        Text(text = category.strCategoryDescription,
            textAlign = TextAlign.Justify, // HOVER - 'Justify'
            modifier = Modifier.verticalScroll(rememberScrollState()) // Scroll the Description
            )
    }
}