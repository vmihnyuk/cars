package cars.form;

import cars.menu.Menu;
import framework.BaseForm;
import org.openqa.selenium.By;

public class BaseCarsPage extends BaseForm {

    public BaseCarsPage(By locatorForm){
        super(locatorForm);
    }

    public Menu getMenu() {
        return new Menu();
    }
}
