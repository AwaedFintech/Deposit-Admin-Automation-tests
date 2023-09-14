package Pages.DOM;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DOMBase extends PageBase {
    String sendTextValue ;
    String elementReturnedValue ;

    public DOMBase(WebDriver driver){
        super.initDriver(driver);
    }

    public WebElement getInput(By elementIdentifier){
        return driver.findElement(elementIdentifier);
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public String getOnlyNumberFromText(WebElement element){
        return  element.getText().replaceAll("[^0-9]", "");

    }
    public Integer[] tableHandle_getTableSize(){
        Integer[] tableSize = new Integer[2];
        int rowNum = driver.findElements(By.xpath("//table/tbody/tr")).size();
        int colNum = driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
        tableSize[0] = rowNum;
        tableSize[1] = colNum;
        return tableSize;
    }

    public String table_GetSpecificField(int rowIndex,int columnIndex){
        return driver.findElement(By.xpath("//table/tbody/tr["+rowIndex+"]/td["+columnIndex+"]")).getText();
    }

    // ?? If i need to check two things
    public boolean validateElement(WebElement element,String[] validations){
        boolean status = false;
        for (int i=0; i< validations.length ; i++){
            if(validations[i] == "visible"){
                status = element.isDisplayed();
            }
            if(validations[i] == "clickable"){
                status = element.isEnabled();
            }
            if(validations[i] == "hasText"){
                status = (element.getText()).isEmpty();
            }
        }
        return status;
    }

    public boolean isTextEqualToText(WebElement element, String expectedText){
        if(element.getText() == expectedText)
            return true;
        else
            return false;
    }
    public String getSpecificAttribute(WebElement element, String attribute){
        return  element.getAttribute(attribute);
    }

    public void getFilterOptions(String filter){


    }

}
