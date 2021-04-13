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

#### Tools / libraries used :
* Cucumber
* Gherkin
* Rest Assured
* Maven
* Junit

#### Reports
Reports are generated and placed in target folder
`target/cucumber-html-report.html`

##### [PROBLEM] During the tests, the following problems were seen.
* In this api (POST /api/user), although the email field is a required field, when I send a null or empty character, the response is 200. There is no mandatory field control.
* There is no format check for the email field in this api (POST / api / user). I can set an email in the format I want. For example: "324dsfdsff"
* (GET /api/user/{id}) in this api it may be more correct to give a message not found if the id value is deleted or if it is not valid. In the current situation, Bad Request returns the result if the id value is invalid.
* (DELETE /api/user/{id}) in this api it may be more correct to give a message not found if the id value is deleted or if it is not valid. In the current situation, Bad Request returns the result if the id value is invalid.
* (DELETE /api/user/{id}) In this api, when a user is attempted to be deleted for the second time, "Internal Server Error" is returned in the response. Instead, it may be better to give a "User not found" message.
* In this api (POST /api/car), although the manufacture, model and userId field is a required field, when I send a null or empty character, the response is 200. There is no mandatory field control.
* (GET /api/car/{id}) in this api it may be more correct to give a message not found if the id value is deleted or if it is not valid. In the current situation, Bad Request returns the result if the id value is invalid.
* (PUT / api / car / {id}) cannot update imageUrl value in this api.


