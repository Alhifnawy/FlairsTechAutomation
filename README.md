# OrangeHRM Automation Testing

This project automates the test flow for OrangeHRM using Selenium WebDriver, Cucumber, and TestNG following best practices, such as the Page Object Model (POM) pattern.

## Project Structure
- **src/main/java/orange/pages/:** Contains Page Object Model (POM) classes for interacting with different
  pages of the OrangeHRM site.
  - **AdminPage.java:** Page Object for the Admin Homepage.
  - **LoginPage.java:** Page Object for the Login page.
- **src/test/java/resources/feautures/:** Contains feature files like `admin.feature` written in Gherkin syntax (`Given-When-Then`).
- **src/test/java/runners/TestRunner:** Executes the Cucumber scenarios and generates reports.
- **src/test/java/stepDefinitions/:** Contains step definition files like `Steps.java`. These map Gherkin steps to Selenium actions.


## Prerequisites

Before running the tests, ensure you have the following installed:

1. **Java**: Ensure you have Java 8 or higher installed.
2. **Maven**: Ensure Maven is installed to manage dependencies.
3. **WebDriver**: Uses WebDriver Manager for automatic driver handling, so no need to manually download ChromeDriver or others.
4. **IDE**: Recommended to use IntelliJ IDEA or Eclipse for development.

## Setup

### 1. **Clone the Repository**

```bash
git https://github.com/Alhifnawy/FlairsTechAutomation.git
```
### 2. **Navigate to the project directory and use Maven to install the required dependencies:**
    
```bash
mvn install
```   
Dependencies include:

- Selenium WebDriver
- Cucumber Java
- Cucumber TestNG
- TestNG
- WebDriver Manager

The dependencies are defined in the pom.xml file.

## Running the Tests
#### Running via Maven:
Use the following command to execute the tests:
```bash
mvn test
```
#### Running Tests from IDE
1. Import the project: Import the Maven project into your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
2. Right-click on the TestRunner.java file and run it as a TestNG test.
