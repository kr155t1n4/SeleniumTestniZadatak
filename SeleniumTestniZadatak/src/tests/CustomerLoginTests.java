package tests;

import org.junit.Test;
import pages.CustomerLoginPage;
import pages.HomePage;

public class CustomerLoginTests extends BaseTest {

    String expectedErrorEmptyUsername = "This is a required field.";
    String expectedErrorEmptyPassword = "This is a required field.";
    String expectedErrorWrongUsernameOrPassword = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    String expectedErrorUsernameWithoutAtSign ="Please enter a valid email address (Ex: johndoe@domain.com).";
    String expectedSingInBtn = "Sign In";

    @Test
    public void verifySucessfullLogin(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, validPassword);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.verifySuccessfulLogin();
        }

    @Test
    public void verifyUnsuccessfulLoginEmptyUsername(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login("", validPassword);
        homePage.verifyUnsuccessfulLoginEmptyEmail(expectedErrorEmptyUsername);
    }

    @Test
    public void verifyUnsuccessfulLoginEmptyPassword(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, "");
        homePage.verifyUnsuccessfulLoginEmptyPassword(expectedErrorEmptyPassword);
    }

    @Test
    public void verifyUnsuccessfulLoginErrorWrongUsername(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login("kristina.b@gmail.co", validPassword);
        homePage.verifyUnsuccessfulLoginWrongUsernameOrPassword(expectedErrorWrongUsernameOrPassword);
    }

    @Test
    public void verifyUnsuccessfulLoginErrorWrongPassword(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, "qwerty");
        homePage.verifyUnsuccessfulLoginWrongUsernameOrPassword(expectedErrorWrongUsernameOrPassword);
    }

    @Test
    public void verifyUnsuccessfulLoginErrorUsernameWithoutAtSign(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login("kristina.b", validPassword);
        homePage.verifyUnsuccessfulLoginErrorUsernameWithoutAtSign(expectedErrorUsernameWithoutAtSign);
    }

    @Test
    public void verifySucessfullLogout(){
        HomePage homePage = new HomePage(driver);
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        homePage.goToHomePage();
        homePage.signInBtnFun();
        customerLoginPage.login(validEmail, validPassword);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.dropDownAccountBtnFun();
        homePage.signOut();
        homePage.verifySuccessfulSignOut(expectedSingInBtn);
    }

}