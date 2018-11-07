package cars.form;

import cars.models.Car;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;

public class CompareCarsPage extends BaseCarsPage{

    private static By formLocator = By.xpath("//h2[text()=' Compare Cars Side-by-Side ']");
    private String strLocatorCmb = "//select[@name='%s']";
    private ComboBox cmbMake = new ComboBox(By.xpath(String.format(strLocatorCmb, "makeDropdown")));
    private ComboBox cmbModel = new ComboBox(By.xpath(String.format(strLocatorCmb, "modelDropdown")));
    private ComboBox cmbYear = new ComboBox(By.xpath(String.format(strLocatorCmb, "yearDropdown")));
    private Button btnStartComparing = new Button(By.xpath("//button[@class='done-button']"));

    public CompareCarsPage() {
        super(formLocator);
    }

    public void setCmbValue(Car car){
        cmbMake.selectItemByText(car.getMake());
        cmbModel.selectItemByText(car.getModel());
        cmbYear.selectItemByText(Integer.toString(car.getYear()));
        btnStartComparing.clickAndWait();
    }
}
