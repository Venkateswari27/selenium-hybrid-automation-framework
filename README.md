# selenium-hybrid-automation-framework
## Project overview: 
This is an automation framework built for testing a web application using Selenium WebDriver.  
It follows a Hybrid approach using TestNG and Cucumber with Page Object Model design.

## Tech stack
- Java  
- Selenium WebDriver  
- TestNG  
- Cucumber (BDD)  
- Maven  
- Extent Reports  

## Features
- Page Object Model (POM)
- Hybrid framework (TestNG + Cucumber)
- Data-driven testing using Excel
- Screenshot capture on failure
- Retry mechanism for failed tests
- Extent Reports for reporting
- Utility-based reusable design

## Project Structure
- 'src/main/java' → Pages, Base classes, Utilities  
- 'src/test/java' → Test cases, Step Definitions, Runners  
- 'src/test/resources' → Feature files, Config files

## How to Run
This project supports both TestNG and Cucumber execution, which are run separately based on testing needs.

## Reports
Extent Reports are generated after execution
Screenshots captured for failed tests
Reports stored in Reports folder (not committed to Git)
