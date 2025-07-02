package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class AlertsFrameWindowTest extends SharedData {


    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertsFrameWindowsMenu);

        WebElement browserWindowsSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(browserWindowsSubmenu);

        WebElement newTabElement =driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);
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
        elementHelper.clickElement(newWindowElement);
        System.out.println(driver.getCurrentUrl());

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());


    }
}