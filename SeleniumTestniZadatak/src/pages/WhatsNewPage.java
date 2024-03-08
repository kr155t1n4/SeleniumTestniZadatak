package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhatsNewPage extends BasePage{

    public WhatsNewPage(WebDriver driver) {
        super(driver);
    }

    By whatsNewTextBy = By.xpath("//span[@class='base']");
    By addProductSizeBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div[1]/div/div[1]");
    By addProductColorBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div[2]/div/div[1]");
    By addToCartBtnFunBy = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[3]/div/div/div[4]/div/div[1]/form/button/span");
    By noOfProductInCartBy = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]");
    By actualTextSCBy = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span");
    By viewAndEditCartBtnBy = By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[5]/div/a/span");
    String expectedTextWN = "What's New";

    public WhatsNewPage verifyWhatsNewPage (String expectedTextWN){
        String actualTextWN = readText(whatsNewTextBy);
        verifyTextIsTheSame(expectedTextWN, actualTextWN);
        return this;
    }

    public WhatsNewPage addProductSize(){
        clickElement(addProductSizeBy);
        return this;
    }

    public WhatsNewPage addProductColor(){
        clickElement(addProductColorBy);
        return this;
    }

    public WhatsNewPage addToCartBtnFun(){
        clickElement(addToCartBtnFunBy);
        return this;
    }

    public WhatsNewPage productInCartBtnFun(){
        verifyElementIsVisible(noOfProductInCartBy);
        clickElement(noOfProductInCartBy);
        return this;
    }
    
    public WhatsNewPage verifyProductInCart(String expectedTextSC){
        productInCartBtnFun();
        String actuaTextSC = readText(actualTextSCBy);
        verifyTextIsTheSame(expectedTextSC, actuaTextSC);
        return this;
    }

    public WhatsNewPage viewAndEditCartBtnFun(){
        clickElement(viewAndEditCartBtnBy);
        return this;
    }

    public WhatsNewPage addToCart(){
        verifyWhatsNewPage(expectedTextWN);
        addProductSize();
        addProductColor();
        addToCartBtnFun();
        return this;
    }
}
