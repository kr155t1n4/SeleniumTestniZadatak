package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewCustomerAccountPage extends BasePage{

    By InputByFirstName = By.id("firstname");
    By InputByLastName = By.id("lastname");
    By InputByEmail = By.id("email_address");
    By InputByPassword = By.id("password");
    By InputByConfirmPassword = By.id("password-confirmation");
    
    String firstName = "Kristina";
    String lastName = "Babovic";
    String validEmail = "kristina.b@gmail.com";
    String validPassword = "Testing2024+";
    String confirmPassword = "Testing2024+";
    By CreateAnAccountBtnBy = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
    
    public CreateNewCustomerAccountPage (WebDriver driver){
        super(driver);
    }

    public CreateNewCustomerAccountPage CreateNewCustomerAccount(){
        enterText(InputByFirstName, firstName);
        enterText(InputByLastName, lastName);
        enterText(InputByEmail, validEmail);
        enterText(InputByPassword, validPassword);
        enterText(InputByConfirmPassword, confirmPassword);
        clickElement(CreateAnAccountBtnBy);
        return this;
    }
}
