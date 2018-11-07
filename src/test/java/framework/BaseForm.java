package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class BaseForm extends BaseEntity{

    private By locatorForm;

    protected BaseForm(final By locator) {
        locatorForm = locator;
        Assert.assertTrue(isOpen(), "Page was not open!");
    }

    private boolean isOpen() {
        Label pageLbl = new Label(locatorForm);
        return pageLbl.isDisplayed();
    }
}
