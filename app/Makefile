.DEFAULT_GOAL := build-run

# Параметры для проекта
PROJECT_DIR = app

setup:
	@echo "Setting up Gradle Wrapper..."
	@./gradlew -p $(PROJECT_DIR) wrapper --gradle-version 8.3

clean:
	@echo "Cleaning project..."
	@./gradlew -p $(PROJECT_DIR) clean

build:
	@echo "Building project..."
	@./gradlew -p $(PROJECT_DIR) build

install:
	@echo "Installing project..."
	@./gradlew -p $(PROJECT_DIR) install

run-dist:
	@echo "Running distribution..."
	@./$(PROJECT_DIR)/build/install/$(PROJECT_DIR)/bin/$(PROJECT_DIR) -h

run:
	@echo "Running project..."
	@./gradlew -p $(PROJECT_DIR) run

test:
	@echo "Running tests..."
	@./gradlew -p $(PROJECT_DIR) test

report:
	@echo "Generating report..."
	@./gradlew -p $(PROJECT_DIR) jacocoTestReport

lint:
	@echo "Running lint checks..."
	@./gradlew -p $(PROJECT_DIR) checkstyleMain

check-deps:
	@echo "Checking dependencies..."
	@./gradlew -p $(PROJECT_DIR) dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build setup clean install run-dist run test report lint check-deps build-run
