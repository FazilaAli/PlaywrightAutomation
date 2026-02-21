# Automation Framework (UI + API)

**Key Concepts Demonstrated:**

This project showcases expertise in the following areas:

### **Programming & Scripting**
* **End-to-end Automation:** UI & API testing with modular, reusable components.
* **Positive and Negative Cases:** UI & API testcases to examine Web/API behaviour.
* **Data-driven Testing:** JSON-based test data & schema validations.
* **Java** – Core language used for building automation scripts.
* **OOP Concepts** – Encapsulation, inheritance, abstraction applied for reusable code.
* **JSON Handling** – Reading and validating test data via JSON files.

### **Test Automation**

* **UI Automation**

  * **Playwright for Java** – Cross-browser automation.
  * **Page Object Model (POM)** – Structured design for maintainable tests.
  * **Assertions & Locators** – Using XPath, CSS selectors, and dynamic locators.
* **API Automation**

  * **REST-assured** – Sending HTTP requests, validating responses, schema validation.
  * **Data-driven testing** – Using JSON for dynamic API inputs.

### **Framework Design**

* Modular folder structure separating base classes, page objects, test scripts, and utilities.
* Reusable utility classes for config and JSON reading.
* Clear separation of **UI** and **API** test cases.

### **Testing & Quality Practices**

* **Automated Validation** – Login, signup, checkout, product addition.
* **Schema Validation** – JSON schema for API response verification.
* **Cross-functional Testing** – Combining API and UI automation for end-to-end scenarios.

**Project Structure & Highlights:**

```
src
 └── java
     ├── base
     │   └── BaseTest.java          # Base class for test setup and teardown
     ├── pageobjects
     │   ├── DemoBlaze.java          # Page object for DemoBlaze application
     │   └── SauceDemo.java          # Page object for SauceDemo application
     ├── pages
     │   ├── AddProducts.java        # Methods for adding products in UI
     │   ├── Checkout.java           # Checkout flow automation
     │   └── Login.java              # Login page methods
     ├── Utils
     │   ├── ConfigReader.java       # Reads configuration properties
     │   └── JsonReader.java         # Handles JSON test data
 └── test
     └── java
         ├── API
         │   ├── TestData            # API test data
         │   └── UserApiTest.java    # User API automation
         └── UI
             ├── TestData            # UI test data
             ├── LoginTest.java      # Login functionality tests
             ├── PlaceOrder.java     # Place order tests
             └── SignupTest.java     # Signup functionality tests
 └── resources
     └── schemas
         └── user-schema.json        # JSON schema validation for API
```

**Tech Stack & Tools:**

* **Languages:** Java
* **Test Automation:** Playwright (UI), REST Assured (API)
* **Test Frameworks:** TestNG / JUnit
* **Build & Dependency:** Maven
* **Utilities:** JSON handling, ConfigReader
* **Version Control:** Git & GitHub
* **CI/CD (optional):** GitHub Actions / Azure Pipelines

This project reflects hands-on experience in:

* Building **scalable automation frameworks** for both UI and API testing.
* Writing **clean, maintainable, and reusable code**.
* Integrating modern automation tools like **Playwright** and **REST-assured**.
* Implementing **real-world testing practices** including data-driven testing and schema validation.
