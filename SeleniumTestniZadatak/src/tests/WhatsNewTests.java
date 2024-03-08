package tests;

import org.junit.Test;

import pages.CustomerLoginPage;
import pages.HomePage;
import pages.WhatsNewPage;

public class WhatsNewTests extends BaseTest{
    
    
    String expectedTextSC = "View and Edit Cart";

    @Test

    public void addWhatsNewProduct(){
        HomePage homePage = new HomePage (driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);


        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, validPassword);
        homePage.whatsNewBtnFun();
        whatsNewPage.addToCart();
        whatsNewPage.verifyProductInCart(expectedTextSC);
    }
}
