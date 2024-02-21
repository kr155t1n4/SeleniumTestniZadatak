package tests;

import org.junit.Test;

import pages.HomePage;

public class HomePageTests extends BaseTest{

    @Test
    public void verifyHotSellersProducts(){
        HomePage homePage = new HomePage(driver);

        homePage.goToHomePage();
        }
    }
