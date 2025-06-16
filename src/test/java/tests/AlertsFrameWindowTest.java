package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AlertsFrameWindowTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com");

        //facem browser-ul sa fie in modul maxiize
        driver.manage().window().maximize();

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsMenu.click();

        WebElement browserWindowsSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsSubmenu.click();

        WebElement newTabElement =driver.findElement(By.id("tabButton"));
        newTabElement.click();
        System.out.println(driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());

        //schimba tab-ul in browser
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());

        //inchidem tab-ul pe care te afli in momentul respectiv //driver.quite() - inchide tot browser-ul
        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        //din cauza reclamei fortam site-ul sa acceseze un URL specific
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindowElement =driver.findElement(By.id("windowButton"));
        newWindowElement.click();
        System.out.println(driver.getCurrentUrl());

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}