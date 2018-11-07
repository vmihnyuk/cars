package cars.form;

import org.openqa.selenium.By;

public class MainPage extends BaseCarsPage {

    private static By formLocator = By.xpath("//h1[contains(text(), 'Find your')]");

    public MainPage() {
        super(formLocator);
    }


}