package cars.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/cars/features/",
        glue = "cars.steps",
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests{}