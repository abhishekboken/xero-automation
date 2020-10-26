# Test Automation Westpac

Web UI automation scenarios for Westpac KiwiSaver Retirement Calculator.

As per the requirement,

First feature file contains a scenario which will fail with assertion error and screenshot in the cucumber report.

Second feature file contains three scenarios outlined considering the best practices.

**Technology stack**: 

Java, Selenium, WebDriverManager, Cucumber, Maven, Junit, Hamcrest, Log4J.

**Software versions:**

IntelliJ IDEA 2020.2.3 (Community Edition)
OS: Windows 10

**Setup**:

Required: Java 8, IntelliJ, Maven, , Cucumber for Java plugin, Gherkin plugin.

Go to New --> Project from version control --> enter Repository URL

The cloned project can also be imported into intelliJ as a maven project. All dependencies present in pom.xml will get downloaded by Maven.

**Feature File**

All the test BDD scenarios are present in feature files located in "features" folder.

**Execution**:

Method 1: Tests can be executed once the project is imported into IntelliJ. Run the CucumberFeaturesRunner.java class present in com.westpac.runner package.

OR

Method 2: It can be run from cmd prompt or terminal using the command(from project root directory)
"mvn test"
Note: Maven should be installed and path should be set up in order to run scripts from cmd/terminal

**Reporting**:

Reports are generated in "target/cucumber" folder. To view cucumber report, right click on cucumber.html, select "Show in Explorer" and open with browser.

**Logging**:

The logging level is INFO, console, file.