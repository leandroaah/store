package minsa.test.store;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        extraGlue = {"classpath/stepdefinitions", "minsa/test/store/stepdefinitions"})
class StoreApplicationTests {

}
