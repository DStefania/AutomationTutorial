package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.IndexPage;
import pages.WindowsPage;
import sharedData.SharedData;
import suite.Suite;

public class AlertsFrameWindowTest extends SharedData {

    @Test (groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE, Suite.ALERTWINDOWFRAME_SUITE})
    public void testMethod() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.dealWIthNewTab();
        windowsPage.dealWithNewWindow();
    }
}