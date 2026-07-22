# Architecture — starter-mobile-kotlin

## Choix opinionated

### 1. 100% Jetpack Compose

Pas de XML, pas de View system. `Theme.kt` centralise Material 3. `Navigation Compose` pour le routing.

### 2. Hilt pour la DI, KSP pour l'AP

Hilt = composants scoped Android (Application, Activity, ViewModel) avec peu de boilerplate. KSP > kapt.

### 3. Ktor + kotlinx.serialization pour HTTP

- Même client Android / JVM / iOS si tu passes en KMP.
- `kotlinx.serialization` évite la réflexion Gson/Moshi.

### 4. Room pour la DB locale

`androidx.room` = DB library recommandée Google. DAO interfaces, Flow natif.

### 5. Kotlin coroutines + Flow

Async partout : `viewModelScope.launch`, `StateFlow` pour UI, `Flow` depuis les DAOs.

### 6. Version catalog (`libs.versions.toml`)

Source unique de vérité pour toutes les versions.

## Hors scope

- Auth (MSAL, OIDC custom).
- WorkManager.
- Push (FCM).
- Analytics / crash reporting.
