.PHONY: dev build test lint clean help

help:
	@echo "Targets: dev / build / test / lint / clean"

dev:
	./gradlew installDebug

build:
	./gradlew assembleRelease

test:
	./gradlew testDebugUnitTest

lint:
	./gradlew lintDebug

clean:
	./gradlew clean
