# Overview
Anonymous-Chat is an Android messaging app that supports Anonymous Identity, so no need for phone or email to sign-in, only depends on public-key identifier. It also supports end-to-end encryption depending on Public-key cryptography mechansim.

<img src="https://serving.photos.photobox.com/79022967fb9b75c1748dad12d855cb5aa296b2bd755b5325c41d3d0c9f3617b07fc3e377.jpg" width="200" height="400" /> <img src="https://serving.photos.photobox.com/06226340c048ebc21eb4100efebf46ae3c88bb989531d74cda46e62d2f68227251d840d2.jpg" width="200" height="400" />

###### ***Project for demonstartion purpose***


### Model-View-Intent (MVI) Architecture
Project implements MVI Architecture

<img src="https://miro.medium.com/max/841/1*u6DY_91Uu6RhwPfaeftggQ.png" width="700" height="400" />

### Clean Architecture
For applying single responsiblity and seperation of concerns principles, the project consists of three main modules;
- presentation layer; contains Android specific components, UI(activities, fragments), viewmodels and contracts(for intents and viewstates)
- data layer; contains repositories and data sources implementations (database definition and its DAOs / network APIs definitions), mappers(for remote and item models)
- domain layer; contains the definitions of the business logic of the app and the data model,


### Dependency Injection
Koin framework (https://github.com/InsertKoinIO/koin) is used for Dependency Injection. Koin modules are defined under presentation->base->di

### Kotlin Coroutines
Coroutines (https://kotlinlang.org/docs/coroutines-guide.html) is used for asynchronous programming.

### Networking layer
Socket.io (https://socket.io/) used for connecting websocket.

### Room Database
Room DB (https://developer.android.com/jetpack/androidx/releases/room) is used for caching user's conversations list.

### Cryptography
LazySodium (https://github.com/terl/lazysodium-android) is used for generating pair-keys./ encrypting and decrypting messages.

-------
