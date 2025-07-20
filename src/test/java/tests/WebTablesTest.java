package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubMenu();

        int tableSize = 3;
        String firstnameValue = "Stef";
        String lastnameValue = "Danila";
        String emailValue = "1224trs@gmal.com";
        String ageValue = "30";
        String salaryValue = "3620";
        String departmentValue = "IT";
        String editFirstNameValue = "Stefuta";
        String editLastNameValue = "David";
        String editEmailValue = "akjakahd@yahoo.com";
        String editAgeValue = "65";
        String editSalaryValue = "6500";
        String editDepartmentValue = "QA";

        WebTablePage webTablePage = new WebTablePage(driver);

        webTablePage.addNewEntry(tableSize, firstnameValue, lastnameValue, emailValue, ageValue, salaryValue, departmentValue);

        webTablePage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue, editSalaryValue, editDepartmentValue);

        webTablePage.deleteNewEntry(tableSize);
    }
}
