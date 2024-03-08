package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By subtotalPriceBy = By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span");
    By taxPriceBy = By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[2]/td/span");
    By orderPriceBy = By.xpath(" //*[@id=\"cart-totals\"]/div/table/tbody/tr[3]/td/strong/span");
    
    public ShoppingCartPage verificationOfTotalPrice(){
        String subtotalPriceText = readText(subtotalPriceBy).substring(1);
        double doubleSubtotalPrice = convertTextToNumber(subtotalPriceText);
        String taxPriceText = readText(taxPriceBy).substring(1);
        double doubleTaxPrice = convertTextToNumber(taxPriceText);
        String orderPriceText = readText(orderPriceBy).substring(1);
        double doubleOrderPrice = convertTextToNumber(orderPriceText);

        verifyPrice(doubleSubtotalPrice + doubleTaxPrice, doubleOrderPrice);
        return this;
    }

}
