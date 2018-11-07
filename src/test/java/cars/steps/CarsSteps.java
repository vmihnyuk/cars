package cars.steps;

import cars.form.*;
import cars.models.Car;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;


public class CarsSteps {

    private MainPage mainPage;
    private ResearchPage researchPage;
    private CarPage carPage;
    private CompareTrimsPage compareTrimsPage;
    private CompareCarsPage compareCarsPage;
    private ModelComparePage modelComparePage;
    private AddAnotherCarPage addAnotherCarPage;
    private Map<String, Car> mapCars = new HashMap<String, Car>();
    SoftAssert softAssert = new SoftAssert();

    @Given("^User is on Home page$")
    public void userIsOnHomePage() {
        mainPage = new MainPage();
    }

    @When("^User navigates to '(.*)' from main page$")
    public void userNavigateTo(String item){
        mainPage.getMenu().navigateItem(item);
    }

    @Then("^User is on Research page$")
    public void userIsOnResearchPage() {
        researchPage = new ResearchPage();
    }

    @When("^User chooses a '(.*)' car$")
    public void userChoosesACarAndClickSearch(String key) {
        mapCars.put(key, researchPage.chooseCar());
    }

    @Then("^Combobox for the '(.*)' car filled correctly$")
    public void comboboxFilledCorrectly(String key) {
        Assert.assertNotEquals(mapCars.get(key).getMake(),"All Makes",
                "Combobox Make is filled incorrectly");
        Assert.assertNotEquals(mapCars.get(key).getModel(),"All Models",
                "Combobox Model is filled incorrectly");
        Assert.assertNotEquals(mapCars.get(key).getYear(), "All Years",
                "Combobox Year is filled incorrectly");
    }

    @When("^User click Search$")
    public void userClickSearch() {
        researchPage.clickSearch();
    }

    @Then("^User is on Car page$")
    public void userIsOnCarPage() {
        carPage = new CarPage();
    }

    /**
     * Method checks if there is a Compare Trims Button on the page
     * If there is no button, select a new car
     * If button exsists, click button
     * @param key   key for Car object
     */
    @When("^User navigate to Compare Trims for the '(.*)' car$")
    public void userNavigateToCompareTrims(String key) {
        carPage.getCarName(mapCars.get(key));
        int i;
        for(i=0; i<5; i++){
            if (carPage.isDisplayedBtnCompareTrims()){
                carPage.clickbtnCompareTrims();
                break;
            }
            userNavigateTo("RESEARCH");
            userChoosesACarAndClickSearch(key);
            userClickSearch();
        }
        if (i == 5) Assert.fail("There is no button Trims");
    }

    @Then("^User is on Compare Trims Page$")
    public void userIsOnCompareTrimsPage() {
        compareTrimsPage = new CompareTrimsPage();
    }

    @When("^Save Engine and Trims of the '(.*)' car$")
    public void saveEngineAndTrimsOfTheFirstCar(String key) {
        compareTrimsPage.saveBaseEngines(mapCars.get(key));
        compareTrimsPage.saveTrans(mapCars.get(key));
    }

    @And("^User navigate to main page$")
    public void userNavigateToMainPage() {
        compareTrimsPage.getMenu().navigateToMainPage();
    }

    @Then("^User is on main page$")
    public void userIsOnMainPage() {
        mainPage = new MainPage();
    }

    @When("^User click Comparisons button$")
    public void userClickComparisonsButton() {
        researchPage.clickComparisons();
    }

    @Then("^User is on Compare Cars page$")
    public void userIsOnCompareCarsPage() {
        compareCarsPage = new CompareCarsPage();
    }

    @When("^User chooses '(.*)' car for compare$")
    public void userChoosesFirstCarForCompare(String key) {
        compareCarsPage.setCmbValue(mapCars.get(key));
    }

    @Then("^User is on Model Compare page$")
    public void userIsOnModelComparePage() {
        modelComparePage = new ModelComparePage();
    }

    @When("^User adds '(.*)' car for compare$")
    public void userAddsCarForCompare(String key) {
        addAnotherCarPage.setCmbValue(mapCars.get(key));
    }

    @Then("^User is on Add Another Car page$")
    public void userIsOnAddAnotherCarPage() {
        addAnotherCarPage = new AddAnotherCarPage();
    }

    @When("^User click Add Another Car$")
    public void userClickAddAnotherCar() {
        modelComparePage.clickBtnClickAddAnotherCar();
    }

    @And("^Compare parameters of '(.*)' car$")
    public void compareParametersOfFirstAndSecondCars(String key) {
        softAssert.assertEquals(mapCars.get(key).getAvailableEngines(),
                modelComparePage.getEngine(mapCars.get(key)),
                "Engine doesn't match on different pages!");
        softAssert.assertEquals(mapCars.get(key).getTransmissions(),
                modelComparePage.getTransmission(mapCars.get(key)),
                "Transmission doesn't match on different pages");
        softAssert.assertEquals(mapCars.get(key).getName(),
                modelComparePage.getCarName(mapCars.get(key)),
                "Car name doesn't match on different pages");
        softAssert.assertAll();
    }

    @And("^User navigates to '(.*)' from Compare Trims Page$")
    public void userNavigatesToRESEARCHFromCompareTrimsPage(String item) {
        compareTrimsPage.getMenu().navigateItem(item);
    }
}