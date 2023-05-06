# JetNewsApp

JetNewsApp is a sample news application built using Jetpack Compose and Clean Architecture.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

# Prerequisites
Android Studio Arctic Fox or newer
Android SDK 30 or newer
Installing
Clone the repository using the following command:

bash
# Copy code
git clone https://github.com/Ravinnpawar/JetNewsApp.git
Open Android Studio and select "Open an existing Android Studio project."

Navigate to the cloned repository and select the build.gradle file.

Wait for the project to sync and build.

Run the app using an emulator or connected device.

# Architecture
JetNewsApp follows the principles of Clean Architecture and the Model-View-ViewModel (MVVM) pattern.

# Modules
app: This module contains the UI and presentation logic of the app. It depends on the data module for data and the domain module for business logic.
data: This module contains the data layer of the app, including repositories and data sources. It depends on the domain module for business logic.
domain: This module contains the business logic of the app, including use cases and entities. It does not depend on any other modules.
Libraries
JetNewsApp uses the following libraries:

# Jetpack Compose for UI
Hilt for dependency injection
Retrofit for network requests
Room for local data storage
Coroutines for asynchronous programming
Truth for testing assertions
Contributing
Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

# Authors
Ravindra Pawar - Initial work - Ravinnpawar
See also the list of contributors who participated in this project.

# License
This project is licensed under the MIT License - see the LICENSE.md file for details.

# Acknowledgments
The Android team for Jetpack Compose
The team behind Clean Architecture and MVVM
