package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * created by Andrey Melnichenko at 13:10 29-08-2018
 */
@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/features/Mdp.feature","src/test/java/features/UserBehavior.feature"},
        plugin = {"pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json"},
        glue = {"steps", "utils"},
        tags = {"@all","@userAction","@debug"},
        snippets = SnippetType.UNDERSCORE)

public class RunnerTest {
}
