package cars.menu;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu extends BaseForm {

    private static By locatorMenu = By.xpath("//img[@alt='Cars.com']");
    private Label lblLogo = new Label(By.xpath("//img[@alt='Cars.com']"));

    public Menu(){
        super(locatorMenu);
    }

    public enum MainMenu {
        CARS_FOR_SALE("Cars for Sale"),
        SELL_YOUR_CAR("Sell Your Car"),
        SERVICE_AND_REPAIR("Service & Repair"),
        RESEARCH("Research"),
        VIDEOS_AND_REVIEWS("Videos & Reviews"),
        SIGN_UP("Sign Up");

        private String innerText;
        private By itemLocator;
        private String locatorString = "//header/nav/ul//a[contains(text(), '%s')]";

        MainMenu(String innerText) {
            this.innerText = innerText;
            this.itemLocator = By.xpath(String.format(locatorString, innerText));
        }

        public By getLocator(){
            return this.itemLocator;
        }
    }

    public void navigateItem(String name) {
        MainMenu mainItem = MainMenu.valueOf(name);
        Button mainItemLbl = new Button(mainItem.getLocator());
        mainItemLbl.clickAndWait();
    }

    public void navigateToMainPage(){
        lblLogo.clickAndWait();
    }
}
