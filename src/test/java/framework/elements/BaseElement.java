package framework.elements;

import framework.BaseEntity;
import framework.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement extends BaseEntity{

    protected By locator;
    protected List<BaseElement> elements;

    public BaseElement(By elementLocator) {
        locator = elementLocator;
    }

    public void waitForIsElementPresent(){
        Waiter.waitForElementDisplayed(browser.getDriver(), locator);
    }

    public void waitAndClick(){
        Waiter.waitUntilClickable(browser.getDriver(), locator);
        findElement().click();
    }

    public String getText(){
        waitForIsElementPresent();
        return findElement().getText();
    }

    public WebElement findElement(){
        if(browser.getDriver().findElements(locator).size() > 0) return browser.getDriver().findElement(locator);
        else return null;
    }

    public boolean isDisplayed(){
        if(browser.getDriver().findElements(locator).size() > 0) return findElement().isDisplayed();
        else return false;
    }

    public void moveToElement(){
        waitForIsElementPresent();
        Actions builder = new Actions(browser.getDriver());
        Action moveMouse = builder
                .moveToElement(browser.getDriver().findElement(locator))
                .build();
        moveMouse.perform();
    }

    public String getAttribute(String attribute){
        waitForIsElementPresent();
        return findElement().getAttribute(attribute);
    }

    public void clickAndWait(){
        waitAndClick();
        browser.waitForPageToLoad();
    }
}
