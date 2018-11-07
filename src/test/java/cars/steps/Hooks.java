package cars.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BaseEntity;
import framework.PropertyReader;
import framework.Waiter;

public class Hooks extends BaseEntity {

    @Before
    public void before() {
        browser.setMaximizeWindow();
        Waiter.implicitWait(browser.getDriver());
        browser.navigate(PropertyReader.getTestProperty("url"));
    }

    @After
    public void after(){
        browser.quit();
    }
}
