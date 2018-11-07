package cars.form;

import cars.models.Car;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CompareTrimsPage extends BaseCarsPage{

    private static By formLocator = By.xpath("//h1[contains(text(), 'Compare Trims')]");
    private Label lblEngines = new Label(By.xpath("//div[contains(text(), '-hp')]"));
    private Label lblTrans = new Label(By.xpath("//div[contains(text(), '-speed')]"));

    public CompareTrimsPage() {
        super(formLocator);
    }

    public void saveBaseEngines(Car car){
        car.setAvailableEngines(lblEngines.getInnerText());
    }

    public void saveTrans(Car car){
        car.setTransmissions(lblTrans.getInnerText());
    }
}
