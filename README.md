# Chirp (KMP)

## 📌 About the project
This is **Chirp** — a real-time chat platform built with Kotlin Multiplatform (KMP). It targets **Android**, **iOS**, and **Desktop (JVM)**, sharing UI and business logic across all platforms using Compose Multiplatform.

## ✨ Features
🔹 User registration, authentication, and profile management

🔹 Real-time chat via WebSocket

🔹 Group and direct messaging

🔹 Push notifications via Firebase Cloud Messaging (FCM)

🔹 JWT-based authentication and authorization

🔹 Offline-first with local database (SQLDelight)

🔹 Image loading with Coil

## 🚀 Techs
- **Kotlin Multiplatform** (Compose Multiplatform)
- **Kotlin**
- **Gradle** (multi-module build)
- **Android** (Compose UI)
- **iOS** (SwiftUI entry point + Compose shared UI)
- **Desktop (JVM)** (Compose for Desktop)
- **SQLDelight** (local database)
- **Ktor Client** (HTTP & WebSocket)
- **Koin** (dependency injection)
- **Kotlinx Serialization**
- **Kotlinx Coroutines**
- **Kotlinx Datetime**
- **Firebase Cloud Messaging** (Push Notifications)
- **Coil** (image loading)
- **DataStore** (local preferences)
- **Kermit** (logging)
- **JWT** (jjwt)

## 🏗 Project Modules
| Module                       | Description                                               |
|------------------------------|-----------------------------------------------------------|
| `composeApp`                 | Shared Compose UI and application entry point             |
| `core:presentation`          | Shared UI components, theming, and navigation utilities   |
| `core:domain`                | Domain models, use cases, and repository interfaces       |
| `core:data`                  | Data layer implementations (repositories, data sources)   |
| `core:designsystem`          | Design system components, colors, typography, icons       |
| `feature:auth:presentation`  | Authentication screens and logic (shared UI)              |
| `feature:auth:domain`        | Authentication domain layer (use cases, models)           |
| `feature:chat:presentation`  | Chat UI screens (chat list, conversation, etc.)           |
| `feature:chat:domain`        | Chat domain layer (messages, rooms, use cases)            |
| `feature:chat:data`          | Chat data layer (repositories, API clients)               |
| `feature:chat:database`      | Local database schema and queries                         |

## 🛠 Installation and Configuration

### Prerequisites
- JDK 21+
- Android Studio (with KMP plugin)
- Xcode (for iOS builds, macOS only)

### Running the project

Clone this repository:
```bash
git clone https://github.com/cainan/chirp-kmp.git
cd chirp-kmp
```

#### Android
To build and run the Android app:
```bash
./gradlew :composeApp:assembleDebug
```

#### Desktop (JVM)
To build and run the Desktop app:
```bash
./gradlew :composeApp:run
```

#### iOS
Open the `iosApp` directory in Xcode and run from there, or use the run configuration from your IDE.

---

Questions or suggestions? Feel free to open an issue or contribute with pull requests! 😊