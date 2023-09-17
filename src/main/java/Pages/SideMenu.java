package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideMenu extends PageBase{
    public SideMenu(WebDriver driver) {
        super.initDriver(driver);
    }

    @FindBy(css = "p.chakra-text.css-en-13ebsbi")
    WebElement lblManagment;

    public void expandManagementMenu(){
        List<WebElement> listele = driver.findElements(By.cssSelector("p.chakra-text.css-en-13ebsbi"));

        clickbutton(listele.get(2));
    }

}
