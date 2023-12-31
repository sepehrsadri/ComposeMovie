# ComposeMovie

The `ComposeMovie` consuming
a [Filimo Api](https://github.com/SabaDroiders/test) to display movies. it
has been built with `Modular` and `Clean Architecture` principles, Repository Pattern, and MVVM
pattern as well as Architecture Components also
utilized with `Android Jetpack` contains: Compose, Hilt and ...

This app shows the usage of the new Android Jetpack and Architecture Components.

**App features:**

- List of movies
- Search movie
- Light / Dark theme switch

## Architecture

Uses concepts of the notorious Uncle Bob's architecture
called [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
.

* Better separation of concerns. Each module has a clear API., Feature related classes life in
  different modules and can't be referenced without explicit module dependency.
* Features can be developed in parallel eg. by different teams
* Each feature can be developed in isolation, independently from other features
* faster compile time

## Modules:

* **app** - It uses all the components and classes related to Android Framework. It gets the data
  from other modules and shows on UI. (**access all the modules**)
* **feature-dashboard** - this feature module contains main screen and use **feature-search** for
  search bar
* **features-search** - - contains search bar
  use [API]("https://api.thecatapi.com/v1/images/search?limit=10&category_ids=5")
* **library** - contains different modules such as **library:core**, **library:data**, **library:
  designsystem**, **library:domain**, **library:domain**, **library:network**, **library:testing**
  which contains business logic of application.

## Tests

This project has been covered with
some [Local Unit Test](https://developer.android.com/training/testing/unit-testing/local-unit-tests)
to passing view model, repository and useCases.

## Tech stack - Library:

- [Kotlin](https://kotlinlang.org/) - Kotlin is a cross-platform, statically typed, general-purpose
  programming language with type inference. Kotlin is designed to interoperate fully with Java, and
  the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference
  allows its syntax to be more concise.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - A coroutine is a concurrency design
  pattern that you can use on Android to simplify code that executes asynchronously
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - for
  dependency injection.
- JetPack
    - [Compose]("https://developer.android.com/jetpack/compose") - Jetpack Compose is Android’s
      recommended modern toolkit for building native UI. It simplifies and accelerates UI
      development on Android. Quickly bring your app to life with less code, powerful tools, and
      intuitive Kotlin APIs.
    - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Used get
      lifecyle event of an activity or fragment and performs some action in response to change
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores
      UI-related data that isn't destroyed on UI changes.
- [Material-Components](https://github.com/material-components/material-components-android) -
  Material design components.
- [Retrofit](https://github.com/square/retrofit) - Used for REST api communication.
- [OkHttp](http://square.github.io/okhttp/) - HTTP client that's efficient by default: HTTP/2
  support allows all requests to the same host to share a socket
- [Gson](https://github.com/google/gson) - Used to convert Java Objects into their JSON
  representation and vice versa.
- [Glide](https://github.com/bumptech/glide) - An image loading library for Android backed by Kotlin
  Coroutines.
- [Timber]("https://github.com/JakeWharton/timber") - This is a logger with a small, extensible API
  which provides utility on top of Android's normal Log class.

## Future Road Map

- Unit test cases are note complete and more test cases for critical components needs to be added
- UI test for screens
- Movie detail screen
- more features to be implemented


