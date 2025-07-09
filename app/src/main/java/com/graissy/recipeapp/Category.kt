package com.graissy.recipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// (1) *** After we add dependencies/internet permission we make a Category data class ***
// we add the parameters according to the properties in 'TheMealDB'
// https://www.themealdb.com/api/json/v1/1/categories.php

@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
) : Parcelable

data class CategoriesResponse(
    val categories: List<Category>
)