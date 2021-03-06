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
        features = {"src/test/java/features"}, ///EnterToApp.feature","src/test/java/features/DocumentActions.feature","src/test/java/features/DataSearch.feature
        plugin = {"pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json"},
        glue = {"steps", "utils"},
        tags = {"@debug"}, //"@all","@userAction",
        snippets = SnippetType.UNDERSCORE)

public class RunnerTest {
}
