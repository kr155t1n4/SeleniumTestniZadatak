package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    String validEmail = "kristina.b@gmail.com";
    String validPassword = "Testing2024+";

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitElementToBeVisible (By elementBy){
        wait.until (ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    /**
     * @param elementBy
     */
    public void verifyElementIsVisible(By elementBy){
        boolean isVisible;

        //probaj da uradis nesto
        try {
            waitElementToBeVisible(elementBy);
            isVisible = driver.findElement(elementBy).isDisplayed();
        }
        //AKO naidjes na gresku, izvrsi catch blok
        catch (Exception e){
            isVisible = false;
        }
    
        Assert.assertTrue(isVisible); 
    }

    public void waitElementsToBeVisible (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public int countNumberOfElements (By elementBy){
        waitElementsToBeVisible(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void verifyNumberOfElements(int expectedNum, int actualNum){
        Assert.assertEquals(expectedNum, actualNum);
    }

    public void waitElemntToBeClickable(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    
    public void clickElement(By elementBy){
        waitElemntToBeClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    public void enterText(By elementBy, String text) { //kao parametre prima lokatora i tekst
        waitElemntToBeClickable(elementBy);
        driver.findElement(elementBy).clear(); //ocisti polje ukoliko ima nekog teksta
        driver.findElement(elementBy).sendKeys(text); //pronadji element 
    }

    public String readText(By elementBy){
        waitElementToBeVisible(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void verifyTextIsTheSame(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public double convertTextToNumber(String text){
        return Double.parseDouble(text);
    }

    public void verifyPrice (double expectedPrice, double actualPrice){
        double allowDelta = 0.2;
        Assert.assertEquals(expectedPrice, actualPrice, allowDelta);
    }

}
