package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumHelper;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");
    By topDeals = By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");


    public void searchItem(String name){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchText(){
        driver.findElement(search).getText();
    }

    public String getProductName(){
        SeleniumHelper.waitForElementToExist(driver, By.cssSelector("h4.product-name"));
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage(){
        SeleniumHelper.waitForElementToExist(driver, By.linkText("Top Deals"));
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void incrementQuantity(int quantity){
        int i = quantity - 1;
        while (i > 0){
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart(){
        SeleniumHelper.waitForElementToExist(driver, By.cssSelector(".product-action button"));
        driver.findElement(addToCart).click();
    }
}
