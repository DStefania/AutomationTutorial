package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class EdgeBrowser implements Browser{

    private WebDriver driver;
    private EdgeOptions edgeOptions;


    @Override
    public void openBrowser() {

        configBrowser();
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(this.getClass().getSimpleName());
    }

    @Override
    public void configBrowser() {
        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
      //  edgeOptions.addArguments("window-size=1920,1080");
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-extensions");
        if (cicd){
            edgeOptions.addArguments("--headless=new");
        }

        edgeOptions.addArguments("--incognito");

    }

    public WebDriver getDriver() {
        return driver;
    }
}
