package cars.form;

import cars.models.Car;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;

public class AddAnotherCarPage extends BaseCarsPage{

    private static By formLocator = By.xpath("//h2[contains(text(), 'Add Another Car')]");

    public AddAnotherCarPage() {
        super(formLocator);
    }

    private String strLocatorCmb = "//select[@name='%s']";
    private ComboBox cmbMake = new ComboBox(By.xpath(String.format(strLocatorCmb, "makeDropdown")));
    private ComboBox cmbModel = new ComboBox(By.xpath(String.format(strLocatorCmb, "modelDropdown")));
    private ComboBox cmbYear = new ComboBox(By.xpath(String.format(strLocatorCmb, "yearDropdown")));
    private Button btnDone = new Button(By.xpath("//button[@class='modal-button']"));

    public void setCmbValue(Car car){
        cmbMake.selectItemByText(car.getMake());
        cmbModel.selectItemByText(car.getModel());
        cmbYear.selectItemByText(Integer.toString(car.getYear()));
        btnDone.clickAndWait();
    }

}
