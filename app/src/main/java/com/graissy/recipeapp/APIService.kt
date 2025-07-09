package com.graissy.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// (2) *** We create a 'recipeService' using '@GET' and 'Retrofit' ***


// *(2)*
// Builds a connection to the 'baseUrl()' and adds a Gson converter
// We can convert whatever we GET into objects in Kotlin
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// *(3)*
// We want to have this service that allows us to 'GET("categories.php)'
// Then we will convert them into Gson objects that we can then use in Kotlin
val recipeService = retrofit.create(APIService::class.java)

// *(1)*
interface APIService {
    // When we want to get data we use '@GET'
    @GET("categories.php") // from the link in 'Category' data class
    // What will 'suspend' do to the 'getCategories()' function ?
    // It will process it on the background keeping the interface responsive until the data is retrieved
    suspend fun getCategories(): CategoriesResponse
}

