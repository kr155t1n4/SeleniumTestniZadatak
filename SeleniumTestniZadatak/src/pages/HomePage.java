package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }
    

    String baseUrl = "https://magento.softwaretestingboard.com/";

    public HomePage goToHomePage(){
        driver.get(baseUrl);
        return this;
    }
}
