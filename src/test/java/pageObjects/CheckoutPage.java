package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By cartBag = By.cssSelector("[alt='Cart']");
    By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public void checkoutItems(){
        SeleniumHelper.waitForElementToExist(driver, By.cssSelector("[alt='Cart']"));
        driver.findElement(cartBag).click();
        SeleniumHelper.waitForElementToExist(driver, By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoBtn(){
        SeleniumHelper.waitForElementToExist(driver, By.cssSelector(".promoBtn"));
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean verifyPlaceOrder(){
        SeleniumHelper.waitForElementToExist(driver, By.xpath("//button[contains(text(),'Place Order')]"));
        return driver.findElement(placeOrder).isDisplayed();
    }
}
