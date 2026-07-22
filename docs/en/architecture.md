# Architecture — starter-mobile-kotlin

## Opinionated choices

### 1. 100% Jetpack Compose

No XML layouts, no View system. `Theme.kt` centralises Material 3 colours. `Navigation Compose` drives routing.

### 2. Hilt for DI, KSP for annotation processing

Hilt gives Android-scoped components (Application, Activity, ViewModel) with minimal boilerplate. KSP is faster than kapt and is the direction the ecosystem is going.

### 3. Ktor + kotlinx.serialization for HTTP

- Same client on Android, JVM, iOS if you later share code with a KMP module.
- `kotlinx.serialization` avoids the reflection of Gson/Moshi and plays nicely with Kotlin data classes.

### 4. Room for local persistence

`androidx.room` is Google's recommended DB library. Interfaces are DAO-based, Flow support built in.

### 5. Kotlin coroutines + Flow

Async story throughout: `viewModelScope.launch`, `StateFlow` for UI state, `Flow` from DAOs.

### 6. Version catalog (`libs.versions.toml`)

Single source of truth for all versions, referenced by both the top-level and app-level Gradle files.

## What's out of scope

- Auth flows — add MSAL, `authorize` intents, or a custom OIDC.
- WorkManager background jobs.
- Push notifications (FCM) — add when you need cross-service messaging.
- Analytics / crash reporting.
