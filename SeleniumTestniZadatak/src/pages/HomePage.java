package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }
    

    String baseUrl = "https://magento.softwaretestingboard.com/";
    By hotSellersImg = By.xpath("//img [@class = 'product-image-photo']");
    int expectedNumberOfItems = 6;
    By createAnAcountBtn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    By signInBtn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    By loginNoteBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");
    String expectedLoginNote = "Welcome, Kristina B!";
    By errorNoteEmptyEmailBy = By.xpath("//div[@for='email']");
    By errorNoteEmptyPasswordBy = By.id("pass-error");
    By errorNoteWrongUsernameOrPasswordBy = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    By errorNoteUsernameWithoutAtSignBy = By.xpath("//div[@for='email']");
    By dropDownAccountBtnBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    By signOutBtnBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    By whatsNewBtnBy = By.xpath("//*[@id=\"ui-id-3\"]");

    public HomePage goToHomePage(){
        driver.get(baseUrl);
        return this;
    }

    public HomePage compareNoOfHS(){
        List<WebElement> productList = driver.findElements(hotSellersImg);
        int actualNumberOfItems = productList.size();
        verifyNumberOfElements(expectedNumberOfItems, actualNumberOfItems);
        return this;
    }

    public HomePage createAnAcountBtnFun(){
        clickElement(createAnAcountBtn);
        return this;
    }

    public HomePage signInBtnFun (){
        clickElement(signInBtn);
        return this;
    }

    public HomePage verifySuccessfulLogin(){
        String actualLoginNote = readText(loginNoteBy);
        verifyTextIsTheSame(expectedLoginNote, actualLoginNote);
        return this;
    }

    public HomePage verifyUnsuccessfulLoginEmptyEmail(String expectedError){
        String actualErrorMessage = readText(errorNoteEmptyEmailBy);
        verifyTextIsTheSame(expectedError, actualErrorMessage);
        return this;
    }

    public HomePage verifyUnsuccessfulLoginEmptyPassword(String expectedError){
        String actualErrorMessage = readText(errorNoteEmptyPasswordBy);
        verifyTextIsTheSame(expectedError, actualErrorMessage);
        return this;
    }

    public HomePage verifyUnsuccessfulLoginWrongUsernameOrPassword(String expectedError){
        String actualErrorMessage = readText(errorNoteWrongUsernameOrPasswordBy);
        verifyTextIsTheSame(expectedError, actualErrorMessage);
        return this;
    }

    public HomePage verifyUnsuccessfulLoginErrorUsernameWithoutAtSign(String expectedError){
            String actualErrorMessage = readText(errorNoteUsernameWithoutAtSignBy);
            verifyTextIsTheSame(expectedError, actualErrorMessage);
            return this;
        }

    public HomePage dropDownAccountBtnFun(){
        clickElement(dropDownAccountBtnBy);
        return this;
    }

    public HomePage signOut(){
        clickElement(signOutBtnBy);
        return this;
    }

    public HomePage verifySuccessfulSignOut(String expectedSignInBtn){
        String actualSignInBtn = readText(signInBtn);
            verifyTextIsTheSame(expectedSignInBtn, actualSignInBtn);
            return this;
    }

    public HomePage whatsNewBtnFun(){
        clickElement(whatsNewBtnBy);
        return this;
    }
}
