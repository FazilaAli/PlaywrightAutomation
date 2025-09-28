# PlaywrightAutomation

A full-scale end-to-end automation framework built using **Playwright (Java)**, integrated with **TestNG** for test execution and **Allure** for reporting.
This repository demonstrates how to structure, maintain, and run UI automation tests in Java using Playwright.

---

## Table of Contents

1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Repository Structure](#repository-structure)
4. [Prerequisites](#prerequisites)
5. [Setup](#setup)
6. [Running Tests](#running-tests)
7. [Generating Reports](#generating-reports)
8. [Contact](#contact)

---

## Features

* Cross-browser automation with Playwright (chromium, firefox, webkit)
* TestNG for managing test suites, groups, dependencies
* Allure for rich, interactive test reports
* Page Object Model (POM) design for maintainable, scalable tests
* Configuration and environment management
* Hooks (before/after) for setup and teardown
* Logging and debugging support

---

## Tech Stack

| Component           | Purpose                       |
| ------------------- | ----------------------------- |
| Playwright for Java | Browser automation            |
| TestNG              | Test framework                |
| Allure              | Test reporting                |
| Maven               | Build & dependency management |
| Java                | Programming language          |

---

## Repository Structure

Here’s a typical file/folder organization (you can adjust depending on your actual layout):

```
├── .allure/                   # Allure results / report files  
├── src/                       
│   ├── main/
│   │   └── java/              # Core utilities, config, driver setup  
│   └── test/
│       └── java/              # Test classes, page objects  
├── pom.xml                     # Maven configuration  
├── testng.xml                  # TestNG suite definitions  
└── .gitignore                  
```

* `src/main/java` — shared utilities, base classes, configuration handling
* `src/test/java` — test classes, page objects, test data
* `testng.xml` — defines which tests to run, grouping, parallelism
* `.allure` folder — stores results for Allure to generate reports

---

## Prerequisites

Before you begin, ensure you have:

* Java JDK (version 11 or later)
* Maven (3.x) installed and properly configured
* Internet connectivity (to download dependencies)
* (Optional) Browsers: Chrome, Firefox, WebKit (Playwright will manage browser binaries automatically)

---

## Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/FazilaAli/PlaywrightAutomation.git
   cd PlaywrightAutomation
   ```

2. **Install dependencies**

   ```bash
   mvn clean install
   ```

   This will download all required libraries (Playwright, TestNG, Allure, etc.).

3. **Initialize Playwright (if needed)**

   In some setups, you may need to install browser binaries via Playwright.
   (Check your setup script or your `pom.xml` plugin configuration for this step.)

4. **Configure test settings**

   If there’s a configuration file (e.g. `config.properties` or environment variables), update it to match your local or CI environment (URLs, credentials, timeouts, etc.).

---

## Running Tests

You can run tests in different ways:

* **Via Maven command:**

  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```

* **Run a specific test class or package** (via surefire plugin configuration in `pom.xml` or via CLI arguments)

* **From IDE (e.g. IntelliJ)**
  Right-click on your `testng.xml` or test class and select “Run”.

---

## Generating Reports

After running tests:

1. Check the `./allure-results` (or `.allure/`) directory for raw results.
2. To generate an HTML report using Allure:

   ```bash
   allure serve ./allure-results
   ```

   This will build and open a live report in your browser.

You can also configure a pipeline or CI to publish the report.

---

## Contact

For questions or feedback, you can reach me at:

* GitHub: **[FazilaAli](https://github.com/FazilaAli)**
* Email: fazilaali2001@gmail.com

