package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class EdgeBrowser implements Browser{

    private WebDriver driver;
    private FirefoxOptions firefoxOptions;


    @Override
    public void openBrowser() {
        configBrowser();
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Override
    public void configBrowser() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("window-size=1680,1050");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
//      firefoxgeOptions.addArguments("--headless=new");
        firefoxOptions.addArguments("--incognito");

    }

    public WebDriver getDriver() {
        return driver;
    }
}
