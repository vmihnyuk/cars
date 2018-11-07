package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public abstract class BaseEntity {

    protected Browser browser = new Browser();

    private String url;

    @BeforeTest
    public void before(){
        browser.setMaximizeWindow();
        Waiter.implicitWait(browser.getDriver());
        url = PropertyReader.getTestProperty("url");
        browser.navigate(url);
        File directory = new File(new StringBuilder().append(CommonFunctions.getCanonicalPathToResource()).append("downloads").toString());
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    @AfterTest
    public void after(){
        browser.quit();
    }

}
