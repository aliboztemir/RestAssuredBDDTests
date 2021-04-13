package cucumber_options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {"src/test/java/features"},
					glue = {"step_definitions"},
					tags = "@OnlyAdd or @OnlyPut or @OnlyGet or @DeletePlace",
					plugin = { "pretty", "html:target/cucumber-reports.html" },
					monochrome = true
					// Can also be run from Maven using the following command:
					// mvn test -Dcucumber.options="--tags @OnlyPut or @OnlyDelete"
				)
public class TestRunner {

	
}