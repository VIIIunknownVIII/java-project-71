.DEFAULT_GOAL := build-run

FILE1 := ./path/to/file1
FILE2 := ./path/to/file2

setup:
	./gradlew wrapper --gradle-version 8.3

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	@./app/build/install/app/bin/app -h

run:
	./gradlew run --args="$(FILE1) $(FILE2)"

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build
