package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.interactWithPracticeFormSubMenu();

        String firstNameValue = "Elena";
        String lastNameValue = "Zanfir";
        String emailValue = "Elena.zamfir@yahoo.com";
        String mobileValue = "0727123145";
        List<String> subjectsValue = Arrays.asList("Accounting", "Maths", "Arts");
        String genderValue = "Female";
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        String uploadValue = "src/test/resources/Beyond the Sky-16.jpg";
        String adressValue = "Int Mesteacanului 10P1";
        String stateValue = "Uttar Pradesh";
        String cityValue = "Lucknow";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileValue, subjectsValue,
                genderValue, hobbiesValues, uploadValue, adressValue, stateValue, cityValue);

        practiceFormPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue,
                subjectsValue, hobbiesValues, uploadValue, adressValue, stateValue, cityValue);
    }
}

// PROIECT FINAL, creare de cont. loghim, produs in cos, scos, wishlist
//https://automationexercise.com/