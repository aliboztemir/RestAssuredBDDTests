#### Test Execution
* Execute from IDE by right clicking on features folder.
* run `mvn clean test` from command line.

#### Execution screenshots
Execution screenshots are placed in screenshots folder

#### Development Environment
* Windows 10
* IDE - Eclipse

#### Reports
Reports are generated and placed in target folder
`target/cucumber-html-report/index.html`
`target/surefire-reports/RunCucumberTest/Command line test.html`

##### [PROBLEM] Difficult to test on server where posts/comments are not saved
Requests made to [https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com) don't really add any posts / comments,
Its hard to ensure the correct API's requests are made.


##### [SOLUTION] Local server can be installed which supports comments, posts and users
Local server is being used which represents real server this can be changed in `before` method of `World` class.
</br> Local server is hosted at http://localhost:3000  
 * GITHUB project [https://github.com/typicode/json-server]
 * Install server `npm install -g json-server`</br>
 * Start server independently `json-server --watch localJsonServer/db.json` or using before hooks in `World.java`


