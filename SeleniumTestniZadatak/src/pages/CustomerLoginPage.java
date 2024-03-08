package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage{
    
    public CustomerLoginPage (WebDriver driver){
        super(driver);
    }

    By signInBtn = By.id("send2");
    String validEmail = "kristina.b@gmail.com";
    String validPassword = "Testing2024+";
    By InputByEmail = By.id("email");
    By InputByPassword = By.id("pass");

    public CustomerLoginPage login (String email, String password){
        enterText(InputByEmail, email);
        enterText(InputByPassword, password);
        clickElement(signInBtn);
        return this;
    }
}
