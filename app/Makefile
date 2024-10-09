# Define variables
APP_DIR = app
GRADLEW = $(APP_DIR)/gradlew
GRADLE_CMD = $(GRADLEW) -p $(APP_DIR)

# Default goal
.DEFAULT_GOAL := build-run

# Targets

# Clean the project
clean:
	$(GRADLE_CMD) clean

build:
	$(GRADLE_CMD) build

run:
	./$(APP_DIR)/build/install/app/bin/app

test:
	$(GRADLE_CMD) test

report:
	./gradlew jacocoTestReport

install:
	$(GRADLE_CMD) install

run-dist:
	./$(APP_DIR)/build/install/app/bin/app -h  # Show help or main output

build-run: build run

# Linting (if applicable)
lint:
	$(GRADLE_CMD) checkstyleMain

# Check for dependency updates (if applicable)
check-deps:
	$(GRADLE_CMD) dependencyUpdates -Drevision=release

# Phony targets
.PHONY: clean build run test report install run-dist build-run lint check-deps
