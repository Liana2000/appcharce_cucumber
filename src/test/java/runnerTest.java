import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = "src/test/features",
        glue = {"org.examples.appcharge_cucmber"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class runnerTest {

}