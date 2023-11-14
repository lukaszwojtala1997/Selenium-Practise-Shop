package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("QAUrl");
        String browserProperties = properties.getProperty("browser");
        String browserMaven = System.getProperty("browser");

        String browser = browserMaven!= null ? browserMaven : browserProperties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.get(url);
            }
            else if (browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
                driver.get(url);
            }
        }
        return driver;
    }
}
