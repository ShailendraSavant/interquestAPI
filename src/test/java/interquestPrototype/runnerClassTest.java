package interquestPrototype;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/java/resources"},
        //glue="stepdefs",
        plugin={"pretty",
                "json:TargetReport/cucumber.json"},
        tags = {"@test1"}
)

public class runnerClassTest {
}
