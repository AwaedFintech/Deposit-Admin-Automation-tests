package tests;

import Pages.LoginPage;
import Pages.SideMenu;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagementTests extends TestBase{
    TestData data= new TestData();

    @BeforeTest
    public void BeforeTest(){
        loginpage = new LoginPage(driver);
    }

    @Test
    public void verify_expansion_of_Management_Menu(){
        loginpage.login(data.validEmail, data.validPassword);
        SideMenu sidemenu = new SideMenu(driver);
        sidemenu.expandManagementMenu();

    }
}
