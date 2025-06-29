# Calkoo VAT Calculator Automation Framework

## Overview
A test automation framework for the Calkoo VAT Calculator using Java with Cucumber and TestNG

### Requirements
- JDK 17+
- Maven

### Key Dependencies
- Cucumber: BDD framework
- TestNG: Test execution


### Configuration
Environment URLs are defined in `config.properties`:
- base.vatcalculator.url=https://www.calkoo.com/en/vat-calculator

### Reports
Test results are available in `target/cucumber-html-report.html`

### Running Tests
- Run with Maven:
` ` ` mvn clean test` ` `

### Test Automation enhancements:
- Include Retry mechanism for flaky UI tests
- Improve reporting using ExtendReports and taking snapshots of Failed/Passed test steps
- Integrate it with CI/CD pipelines
- Integrate with dashboard for test metrics visualization
