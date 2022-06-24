package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps", //telling where are steps are.
        tags = "Smoke", //what tagToBeExecuted
        dryRun = false, //to see missing texts.
        monochrome = false, //console true/false color changes
        plugin = {"html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json",
                "pretty"
        }
)

public class Runner {
}