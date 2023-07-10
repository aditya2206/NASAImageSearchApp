# NASAImageSearchApp
Git Repository Link (https://github.com/aditya2206/NASAImageSearchApp/tree/main)

This is a NASA Image Search App that allows users to search and view images from NASA's image collection. The app is built using Kotlin and follows the MVVM (Model-View-ViewModel) architecture pattern.

## Libraries Used
- Jetpack Compose: The UI layer of the app is built using Jetpack Compose, a modern toolkit for building native Android UI. Compose offers a declarative approach to UI development, making it easier to build and maintain complex UI screens.

- ViewModel: The ViewModel component from the Android Architecture Components is used to manage and persist UI-related data across configuration changes. It provides a clean separation between the UI and business logic.

- LiveData: LiveData is used to observe changes in data and update the UI accordingly. It provides reactive capabilities and ensures that the UI stays in sync with the underlying data.

- Retrofit: Retrofit is used for making API calls to the NASA API. It provides a simple and concise way to define API endpoints and handles the network operations asynchronously.

- Mockito: Mockito is used for mocking dependencies in unit tests. It allows for easier testing of individual components by creating mock objects for dependencies.

## Architecture Overview
The app follows the MVVM (Model-View-ViewModel) architecture pattern, which promotes separation of concerns and testability. Here's an overview of the app's architecture:

- Model: The Model represents the data used in the app, such as the ImageModel class that encapsulates information about an image.

- View: The View layer is implemented using Jetpack Compose. It consists of composable functions that define the UI components and their behavior.

- ViewModel: The ViewModel serves as the intermediary between the View and the data. It holds the app's state and exposes methods for interacting with the data. It uses LiveData to notify the View of changes in the data.

- Repository: The Repository is responsible for managing the data sources and abstracting the data retrieval logic. In this app, the FetchAPIData class handles the API calls to fetch the image data.

## To build and run the app, follow these steps:

- Clone the repository to your local machine.
- Open the project in Android Studio.
- Build the project by selecting "Build" > "Make Project" from the menu.
- Run the app on an emulator or a physical device by selecting "Run" > "Run 'app'" from the menu.

## Testing

The app includes both unit tests and Android instrumented tests. The unit tests focus on testing the business logic and individual components using Mockito for mocking dependencies. The instrumented tests verify the behavior of the app on a device or emulator.

## Additional Information

- The app supports Android devices running Android 13.0 (API level 33) and above.
- The app requires an internet connection to fetch images from the NASA API.
