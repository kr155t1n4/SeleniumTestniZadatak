package tests;

import org.junit.Test;

import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.WhatsNewPage;

public class ShoppingCartTests extends BaseTest{

    String expectedTextWN = "What's New";
    
    @Test
    public void verificationOfTotalPrice(){
        HomePage homePage = new HomePage (driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);


        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, validPassword);
        homePage.whatsNewBtnFun();
        whatsNewPage.addToCart();
        whatsNewPage.productInCartBtnFun();
        whatsNewPage.viewAndEditCartBtnFun();
        shoppingCartPage.verificationOfTotalPrice();
    }
}
