package cars.form;

import cars.models.Car;
import framework.CommonFunctions;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;

public class ResearchPage extends BaseCarsPage{

    private static By formLocator = By.xpath("//h1[contains(text(), 'Make Smart Choices')]");
    private Button btnSearch = new Button(By.xpath("//input[@value='Search']"));
    private Button btnComparisons = new Button(By.xpath("//a[@data-linkname='compare-cars']"));
    private String strLocatorCmb = "//select[@name='%s']";

    private String strMake = "makeId";
    private String strModel = "modelId";
    private String strYear = "year";

    public ResearchPage() {
        super(formLocator);
    }

    public void clickSearch(){
        btnSearch.clickAndWait();
    }

    public Car chooseCar(){
        Car car = new Car();
        car.setMake(getRandomValue(strMake));
        car.setModel(getRandomValue(strModel));
        car.setYear(Integer.parseInt(getRandomValue(strYear)));
        return car;
    }

    private int getRandomIndex(ComboBox cmbCar){
        if(cmbCar.getSize()==1) return 1;
        return (CommonFunctions.getRandomNumberFromInterval(1, cmbCar.getSize()));
    }

    public String getRandomValue(String parameterCar){
        ComboBox cmbBox = new ComboBox(By.xpath(String.format(strLocatorCmb, parameterCar)));
        cmbBox.selectItemByIndex(getRandomIndex(cmbBox));
        return cmbBox.getCurrentValue();
    }

    public void clickComparisons(){
        btnComparisons.clickAndWait();
    }
}