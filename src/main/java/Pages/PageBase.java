package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    protected static WebDriver driver ;

    public void initDriver(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver, this); //initialize the object
    }


    protected static void clickbutton(WebElement button) {
        button.click();

    }
    protected static void sendText (WebElement textElement , String value) {
        textElement.sendKeys(value);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void GoToSpecificPageFromSideMenu(int pageIndex) {
        List<WebElement> list = driver.findElements(By.className("v-list-item__title"));
        list.get(pageIndex).click();
    }

    public void waitUntilElementIsClickable(By bySelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bySelector)).click();
    }

    public boolean visibilityOfElements(WebElement element){
        return element.isDisplayed();
    }

    public void scrollToTheEndOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

}
