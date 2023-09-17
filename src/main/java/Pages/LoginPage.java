package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super.initDriver(driver);
    }

    @FindBy(name = "email")
    WebElement txtEmail ;

    @FindBy(name = "password")
    WebElement txtPassword ;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

//    @FindBy(className = "chakra-toast__inner css-dixmdy")
//    WebElement txtEmailValidation;
    // Login validations
//    @FindBy(xpath="//div[@id='field-:ro:-feedback' and @aria-live='polite' and @class='chakra-form__error-message css-en-1r66a9x']")
//    public WebElement txtEmailValidation;


    public void login(String email , String password) {
        sendText(txtEmail, email);
        sendText(txtPassword,password);
        clickbutton(btnLogin);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

//    public String getValidationText(){
//        driver.switchTo().frame(txtEmailValidation);
//       return txtEmailValidation.getText();
//    }
}
