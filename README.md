# starter-mobile-kotlin

> A Skilluv starter — Android 15 (SDK 35) + Kotlin 2.0 + Jetpack Compose + Hilt + Ktor + Room.

[![CI](https://github.com/skilluv-community/starter-mobile-kotlin/actions/workflows/ci.yml/badge.svg)](https://github.com/skilluv-community/starter-mobile-kotlin/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](./LICENSE)
[![Skilluv](https://img.shields.io/badge/skilluv-community-emerald)](https://skilluv.io)

## English

### What this is

A production-oriented native Android starter aligned with the current AndroidX baseline:

- **Android compileSdk 35** (Android 15), **minSdk 26**
- **Kotlin 2.0** with the Compose Compiler plugin
- **Jetpack Compose** + **Material 3** (Compose BOM 2024.11)
- **Navigation Compose**
- **Hilt** for DI (with KSP)
- **Ktor** client for HTTP + `kotlinx.serialization`
- **Room** for local persistence
- **JUnit** + Compose UI tests

### Quickstart

```bash
git clone git@github.com:skilluv-community/starter-mobile-kotlin.git
cd starter-mobile-kotlin
# Open in Android Studio (Ladybug 2024.2.1+) and Run.
# Or from the CLI:
./gradlew installDebug
```

You need the Gradle wrapper JAR. If it's missing, run `gradle wrapper --gradle-version 8.10.2` once (or open the project in Android Studio, which regenerates it).

### Structure

```
app/src/main/java/io/skilluv/starter/
  SkilluvApp.kt              @HiltAndroidApp
  MainActivity.kt            @AndroidEntryPoint + NavHost
  ui/
    theme/Theme.kt           Material 3 colors
    screens/                 Home, Counter, ApiDemo, Settings
  data/
    api/                     Ktor GitHub client
    database/                Room entity + DAO + Database
  di/                        Hilt modules (Network, Database)
```

### Docs

- [`docs/en/getting-started.md`](./docs/en/getting-started.md)
- [`docs/en/architecture.md`](./docs/en/architecture.md)

---

## Français

Starter Android natif production-ready. Voir [`docs/fr/getting-started.md`](./docs/fr/getting-started.md).

```bash
git clone git@github.com:skilluv-community/starter-mobile-kotlin.git
cd starter-mobile-kotlin
./gradlew installDebug
```

---

## License

MIT — see [LICENSE](./LICENSE).
