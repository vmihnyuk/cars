package cars.form;

import cars.models.Car;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CarPage extends BaseCarsPage{

    private static By formLocator = By.xpath("//a[contains(text(), 'View Local Inventory')]");
    private Button btnCompareTrims = new Button(By.xpath("//a[@data-linkname='trim-compare']"));
    private Label lblCarName = new Label(By.xpath("//h1[@class='cui-page-section__title']"));

    public CarPage() {
        super(formLocator);
    }

    public void clickbtnCompareTrims(){
        btnCompareTrims.clickAndWait();
    }

    public boolean isDisplayedBtnCompareTrims(){
        return btnCompareTrims.isDisplayed();
    }

    public void getCarName(Car car){
        car.setName(lblCarName.getInnerText());
    }
}
