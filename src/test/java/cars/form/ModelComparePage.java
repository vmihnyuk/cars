package cars.form;

import cars.models.Car;
import framework.CommonFunctions;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ModelComparePage extends BaseCarsPage{

    private static By formLocator = By.xpath("//h1[contains(text(), 'Model Compare')]");
    private Button btnClickAddAnotherCar = new Button(By.xpath("//div[@id='icon-div']"));
    private String strLocatorParameter = "//p[contains(text(), '%s')]";
    private String strLocatorCarName = "//h4[contains(text(), '%s')]";

    private String regexpForComma = "(.*),";

    public ModelComparePage() {
        super(formLocator);
    }

    public void clickBtnClickAddAnotherCar(){
        btnClickAddAnotherCar.clickAndWait();
    }

    public String getEngine(Car car){
        Label lblEngine = new Label(By.xpath(String.format(strLocatorParameter, car.getAvailableEngines())));
        if (lblEngine.getText().endsWith(",")) return CommonFunctions.regexpGetGroup(lblEngine.getText(),regexpForComma, 1);
        return lblEngine.getText();
    }

    public String getTransmission(Car car){
        Label lblTransmission = new Label(By.xpath(String.format(strLocatorParameter, car.getTransmissions())));
        if (lblTransmission.getText().endsWith(",")) return CommonFunctions.regexpGetGroup(lblTransmission.getText(),regexpForComma, 1);
        return lblTransmission.getText();
    }

    public String getCarName(Car car){
        Label lblCarName = new Label(By.xpath(String.format(strLocatorCarName, car.getModel())));
        return lblCarName.getText();
    }
}
