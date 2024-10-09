name: Java CI

on:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'

      - name: Build with Gradle
        run: ./gradlew build

      - name: Run tests
        run: ./gradlew test jacocoTestReport

      - name: Publish code coverage to Code Climate
        uses: paambaati/codeclimate-action@v3.0.0
        env:
          CC_TEST_REPORTER_ID: ${{ secrets.CC_TEST_REPORTER_ID }}
        with:
          coverageCommand: ./gradlew jacocoTestReport
          coverageLocations: ${{ github.workspace }}/app/build/reports/jacoco/test/jacocoTestReport.xml
          prefix: app/src/main/java
          debug: true
