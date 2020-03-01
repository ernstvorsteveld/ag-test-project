package models;

import base.ValueGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.RegistrationPage;
import pages.WelcomePage;

public class RegistrationModel {

    RegistrationPage registrationPage;
    WelcomePage welcomePage;

    private String name;
    private String email;
    private String password;
    private String passwordRepeat;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setupTestData(FormFields field, String newData) {
        name = field == FormFields.NAME ? newData : ValueGenerator.generateAlphabetic(8);
        email = field == FormFields.EMAIL ? newData : ValueGenerator.generate(7) + "@gmail.com";
        password = field == FormFields.PASSWORD ? newData : "aq12AQ!@";
        passwordRepeat = field == FormFields.PASSWORDREPEAT ? newData : "aq12AQ!@";
    }

    public void completeRegistrationForm(WebDriver driver) {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.completeRegistrationForm(name, email, password, passwordRepeat);
        welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        Assert.assertEquals(welcomePage.getHiLoggedUser().getText(), "Hi " + name + "! ·");

    }
}
