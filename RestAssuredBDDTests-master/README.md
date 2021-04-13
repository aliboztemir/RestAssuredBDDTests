#### Project Structure
* Programming Language: JAVA
* IDE: Eclipse
* OS : Windows 10
* Create a Maven project to build the program;
* Add all dependences in pom.xml regarding some frameworks that I used such as Cucumber to manage BDD, Rest-assured to call the web-service REST and added a json-schema-validator to validate JSON response format;

#### BDD requires a feature file to invoke the step definitions:

* Create the scenarios in feature file as per the requirements, so each step in feature file has to match a step definition in class file;
* Following the BDD practices for coding;
* Using the special annotation like "@Background" which is the first method to run for each scenario. Moreover, this is the right place to set up the URI (endpoint) which will be called by HTTP request;

#### Test Execution
* Execute from IDE by right clicking on features folder.
* run `mvn clean test` from command line.
* Can also be run from Maven using the following command: mvn test -Dcucumber.options="--tags @OnlyPut or @OnlyDelete"
* You can also right click and run with junit.

#### Execution screenshots
Execution screenshots are placed in screenshots folder (screenshots/TestExecution-Cucumber.mp4)

#### Used technologies & tools
* Cucumber
* Gherkin
* Rest Assured
* Maven
* Junit

#### Reports
Reports are generated and placed in target folder
`target/cucumber-html-report.html`
`target/surefire-reports/RunCucumberTest/Command line test.html`

##### [PROBLEM] 


##### [SOLUTION] Local server can be installed which supports comments, posts and users



