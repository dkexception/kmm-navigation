# KMM Navigation App 
This is a simple Kotlin Multiplatform app, showcasing a common navigation system for both the Mobile platforms wiz. iOS & Android, using a common "Shared" module.
UI for Android is made using Jetpack Compose (Jetbrains Compose, since we're in Multiplatform universe), and iOS uses pure SwiftUI Views.

## Project structure:

* `/composeApp` contains Android application's UI.

* `/iosApp` contains iOS application. This is the entry point for our app, as it contains the @main Application. This is also where we have added all our SwiftUI Views.

* `/shared` is for the code that will be shared between all targets (i.e. Android & iOS) in the project. We have achieved a shared Kotlin ViewModel between the platforms and a common Navigation system between them, purely written using Kotlin.
