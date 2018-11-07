package framework;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;

    public Browser(){
        this.driver = BrowserFactory.getDriver();
    }


    public void setMaximizeWindow(){
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void navigate(String url){
        driver.get(url);
    }

    public void waitForPageToLoad() {
        Waiter.waitForLoad(driver);
    }

    public void quit() {
        driver.quit();
        driver=null;
    }
}
