# Démarrage — starter-mobile-kotlin

## Prérequis

- Android Studio Ladybug (2024.2.1) ou plus récent
- JDK 17 (Temurin recommandé)
- Android SDK Platform 35 + Build-Tools 35.0.0
- Device Android physique avec debug USB (recommandé) ou émulateur

Espace disque : ~10 GB pour toolchain + émulateur.

## Premier lancement

Ouvrir dans Android Studio, Sync Gradle, Run.

CLI :

```bash
./gradlew installDebug
adb shell am start -n io.skilluv.starter/.MainActivity
```

Si `./gradlew` manque, ouvrir dans Android Studio (régénère le wrapper) ou :

```bash
gradle wrapper --gradle-version 8.10.2
```

## Tests

```bash
./gradlew testDebugUnitTest
./gradlew connectedDebugAndroidTest
```

## Build APK release

```bash
./gradlew assembleRelease
```

APK dans `app/build/outputs/apk/release/`. Signer avec ton keystore avant distribution.
