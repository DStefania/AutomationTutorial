
package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {

    public WebDriver driver;

    @Test
    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com");

        //facem browser-ul sa fie in modul maxiize
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsMenu.click();

        WebElement alertsSubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsSubmenu.click();

        WebElement alertOkbuttonElement = driver.findElement(By.id("alertButton"));
        alertOkbuttonElement.click();

        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        alertWaitButtonElement.click();

        //wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait= driver.switchTo().alert();
        alertWait.accept();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        alertOkCancelElement.click();

        Alert okCancelAlert = driver.switchTo().alert();
        okCancelAlert.dismiss();

         WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
         alertPromptElement.click();
         Alert alertPrompt = driver.switchTo().alert();
         alertPrompt.sendKeys("Formula1");
         alertPrompt.accept();

         driver.quit();

    }
}

