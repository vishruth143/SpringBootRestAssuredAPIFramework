# Spring Boot RestAssured API Framework

This project is a test automation framework that combines Spring Boot with Rest Assured, designed to provide a robust and scalable solution for API testing.

## Project Structure

```
SpringBootRestAssuredAPIFramework/
├──.github
│   ├── workflows/
│   │   ├──ci.yml  
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ea/
│   │   │           └── SpringBootRestAssuredAPIFramework
│   │   │               └── SpringBootRestAssuredAPIFrameworkApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-qa.properties
│   │       └── application-prod.properties
│   └── test/
│       └── java/
│           └── com/
│           │   └── ea/
│           │        └── SpringBootSeleniumFramework/
│           │            │└── features
│           │            │├── UserAPI.feature 
│           │            └── runner/
│           │            │   ├── TestRunner.java  
│           │            └── steps/
│           │            │   ├── CucumberTestContextConfig.java 
│           │            │   ├── Hooks.java 
│           │            │   ├── UserAPISteps.java
│           └── resources/
│           │   └── config/
│           │       ├── payload.json
│               │──testng.xml
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── .gitattributes
```

## Features

- Integration of Spring Boot with Selenium WebDriver
- Page Object Model (POM) design pattern for better maintainability
- Configurable WebDriver setup
- Custom UI element extensions for enhanced functionality
- Support for multiple environments (dev, prod) through Spring profiles

## Prerequisites

- Java 21
- Maven 3.9.9
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/vishruth143/SpringBootRestAssuredAPIFramework.git
   ```

2. Navigate to the project directory:
   ```
   cd SpringBootRestAssuredAPIFramework
   ```

3. Build the project:
   ```
   mvn clean install
   ```

4. Run tests:
   ```
   mvn clean test
   mvn clean test "-Dspring.profiles.active=qa"
   mvn clean test "-Dspring.profiles.active=prod"
   mvn clean verify "-Dspring.profiles.active=qa"
   mvn clean verify "-Dspring.profiles.active=prod"
   ```

## Configuration

- `application.properties`: Contains default configuration properties
- `application-qa.properties`: Contains qa-specific properties
- `application-prod.properties`: Contains production-specific properties
- `WebDriverConfig.java`: Configure Selenium WebDriver options

## Writing Tests

1. Create new page objects in the `pages` package as needed
2. Extend `BasePage` for common functionalities
3. Write test classes using the page objects and Spring Boot's testing annotations

## Acknowledgments

- Spring Boot
- REST Assured
- Cucumber
- Maven
- TestNG