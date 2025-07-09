package com.graissy.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// (3) *** After our Service is ready we make a ViewModel to fetch data ***
// It takes care of the communication between the data and the actual view which is our Main Activity

class MainViewModel : ViewModel() {

    // *(2)*
    // We are creating a private variable
    // And then we create a public variable that will be exposed to other classes that want to access them
    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    // *(4)*
    // Fetch the Categories on initialization
    // The moment 'MainViewModel' is used i want to fetch the categories
    init {
        fetchCategories()
    }

    // *(3)*
    // We create a method that fetches the categories
    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                // This means call the recipeService from 'APIService.kt' and 'getCategories()'
                val response = recipeService.getCategories()
                // When successful we overwrite the '_categorieState'
                _categorieState.value = _categorieState.value.copy(
                    // we overwrite the list with the Categories 'response.categories'
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                // if there is an error then display an error fetching message 'e.message'
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    // *(1)*
    // We create a Recipe State to know: is it loading?, is it empty?, is there an error?
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}