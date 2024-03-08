package tests;

import org.junit.Test;

import pages.CreateNewCustomerAccountPage;
import pages.HomePage;

public class CreateNewCustomerAccountTest extends BaseTest{


    @Test

    public void CreateNewCustomerTest(){
        HomePage homePage = new HomePage(driver);
        CreateNewCustomerAccountPage createNewCustomerAccountPage = new CreateNewCustomerAccountPage(driver);

        homePage.goToHomePage();
        homePage.createAnAcountBtnFun();
        createNewCustomerAccountPage.CreateNewCustomerAccount();

    }
    
}
