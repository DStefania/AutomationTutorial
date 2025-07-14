
package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithAlertsSubMenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("Formula1");
       }
}

