package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    TestData data= new TestData();

    @BeforeTest
    public void BeforeTest(){
        loginpage = new LoginPage(driver);
    }

    @Test
    public void verify_redirection_to_home_incaseof_valid_credentials(){

        loginpage.login(data.validEmail, data.validPassword);
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getMenuTxt(),"Hello Pollet");
    }

    @Test
    public void verify_invalid_Email_credentials(){
        loginpage.login("pollet@rest.com", data.validPassword);
    }
}
