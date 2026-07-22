# Getting started — starter-mobile-kotlin

## Prerequisites

- Android Studio Ladybug (2024.2.1) or later
- JDK 17 (Temurin recommended)
- Android SDK Platform 35 + Build-Tools 35.0.0
- A real Android device with USB debugging (recommended) or an emulator

Disk space: budget ~10 GB for the toolchain and emulator images.

## First run

Open the project in Android Studio. Sync Gradle when prompted, then Run.

From the command line:

```bash
./gradlew installDebug
adb shell am start -n io.skilluv.starter/.MainActivity
```

If `./gradlew` is missing, either open the project in Android Studio (it will generate the wrapper) or run:

```bash
gradle wrapper --gradle-version 8.10.2
```

## Testing

```bash
./gradlew testDebugUnitTest       # JVM unit tests
./gradlew connectedDebugAndroidTest  # Compose UI tests on a connected device
```

## Building a release APK

```bash
./gradlew assembleRelease
```

The APK lands under `app/build/outputs/apk/release/`. Sign with your keystore before distributing.
