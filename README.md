# Restaurant App Live Data
This project is a simple recipe category browsing app that fetches recipe categories from TheMealDB API and displays them in a grid. Users can navigate to a detailed screen for each category showing the image and description.

## Programming Languages / Technologies
Kotlin, Jetpack Compose, Retrofit, Coroutines, Coil, Android Navigation Component

## Features
- ### Fetch and Display Categories:
Retrieves recipe categories asynchronously from TheMealDB API and displays them with images and titles in a 2-column grid layout.

- ### Navigation:
Enables smooth navigation between the categories list and detailed category screens, passing data safely between screens.

- ### Category Detail View:
Shows detailed information for a selected category, including a large image and description text.

- ### State Management:
Uses ViewModel and Kotlin Coroutines to manage loading, error, and success states, updating the UI reactively.

- ### Image Loading:
Loads images efficiently with Coil to handle remote image fetching and caching.

- ### Error and Loading Handling:
Provides user feedback during loading and error states to improve UX.
