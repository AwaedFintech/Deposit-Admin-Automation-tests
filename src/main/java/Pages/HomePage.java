package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super.initDriver(driver);
    }
    @FindBy(id = "menu-button-:rb:")
    WebElement menuLogin;

    public String getMenuTxt(){
        return menuLogin.getText();
    }
}
