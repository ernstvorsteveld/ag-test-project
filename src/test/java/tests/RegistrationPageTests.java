package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.SiitBaseTest;
import base.ValueGenerator;
import models.FormFields;
import models.RegistrationModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.WelcomePage;

public class RegistrationPageTests extends SiitBaseTest {

    private static final String registerPageUrl = RegistrationPage.BASE_URL + "index.php?page=register&action=register";

    private RegistrationPage registrationPage;
    private WelcomePage welcomePage;

    private static final String INVALID_EMAIL_WARNING = "Invalid email address.";
    private static final String NAME_REQUIRED_WARNING = "Name: this field is required.";
    private static final String EMAIL_REQUIRED_WARNING = "Email: this field is required.";
    private static final String PASSWORD_REQUIRED_WARNING = "Password: this field is required.";
    private static final String SECOND_PASSWORD_REQUIRED_WARNING = "Second password: this field is required.";
    private static final String PASSWORD_LENGTH_WARNING = "Password: enter at least 5 characters.";
    private static final String SECOND_PASSWORD_LENGTH_WARNING = "Second password: enter at least 5 characters.";
    private static final String SECOND_PASSWORD_DOES_NOT_MATCH = "Passwords don't match.";
    private static final String EMAIL_ALREADY_IN_USE_WARNING = "x\nThe specified e-mail is already in use";

    @BeforeClass
    public void init_pages() {
        welcomePage = new WelcomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void got_to_page() {
        driver.get(registerPageUrl);
        registrationPage.waitForPage();
    }

    @Test
    public void registrationTest() {
        GIVEN:
        //in before

        THEN:
        assertThat(registrationPage.verifyElementsRegistrationPage()).isTrue();

        RegistrationModel registrationModel = new RegistrationModel();

        WHEN:
        registrationModel.setupTestData(FormFields.NAME, ValueGenerator.generateAlphabetic(8));
        registrationModel.completeRegistrationForm(driver);

        THEN:
        assertThat(welcomePage.isAccountLinkDisplayed()).isTrue();

        CLEANUP:
        welcomePage.clickLogoutLink();
    }

    @Test
    public void validateMandatoryFieldsForRegistration() {
        GIVEN:
        //in before

        WHEN:
        assertThat(registrationPage.verifyElementsRegistrationPage()).isTrue();
        registrationPage.completeRegistrationForm("", "", "", "");

        AND:
        registrationPage.clickCreateButton();

        THEN:
        assertThat(registrationPage.getRegistrationPageNameWarning().getText()).isEqualTo(NAME_REQUIRED_WARNING);
        assertThat(registrationPage.getRegistrationPageEmailWarning().getText()).isEqualTo(EMAIL_REQUIRED_WARNING);
        assertThat(registrationPage.getRegistrationPagePasswordWarning().getText())
                .isEqualTo(PASSWORD_REQUIRED_WARNING);
        assertThat(registrationPage.getRegistrationPageSecondPasswordWarning().getText())
                .isEqualTo(SECOND_PASSWORD_REQUIRED_WARNING);
    }

    @Test
    public void failWhenEmailAlreadyUsed() {
        GIVEN:
        //in before

        WHEN:
        registrationPage.completeRegistrationForm("Mimi", "mimi@mimi.com", "aq12AQ!@", "aq12AQ!@");

        AND:
        registrationPage.clickCreateButton();

        THEN:
        assertThat(registrationPage.getRegistrationPageEmailAlreadyInUse().getText())
                .isEqualTo(EMAIL_ALREADY_IN_USE_WARNING);
    }

    @Test
    public void failWhenInvalidEmailFormat() {
        GIVEN:
        //in before

        WHEN:
        registrationPage.completeRegistrationForm("Mimi", "mimi@mimi@.com@y", "aq12AQ!@", "aq12AQ!@");

        AND:
        registrationPage.clickCreateButton();

        THEN:
        assertThat(registrationPage.getRegistrationPageEmailWarning().getText()).isEqualTo(INVALID_EMAIL_WARNING);
    }

    @Test
    public void failWhenPasswordsDoNotMatch() {
        GIVEN:
        //in before

        WHEN:
        registrationPage.completeRegistrationForm("Mimi", "mimi@mimi@.com@y", "aq12AQ!@", "12345");

        AND:
        registrationPage.clickCreateButton();

        THEN:
        assertThat(registrationPage.getRegistrationPageSecondPasswordWarning().getText())
                .isEqualTo(SECOND_PASSWORD_DOES_NOT_MATCH);
    }

    @Test
    public void verifyPasswordLengthForRegistration() {
        GIVEN:
        //in before

        WHEN:
        registrationPage.waitForPage();
        registrationPage.completeRegistrationForm("Mimi", "mimi@mimi.com", "as", "as");

        AND:
        registrationPage.clickCreateButton();

        THEN:
        assertThat(registrationPage.getRegistrationPagePasswordWarning().getText()).isEqualTo(PASSWORD_LENGTH_WARNING);
        assertThat(registrationPage.getRegistrationPageSecondPasswordWarning().getText())
                .isEqualTo(SECOND_PASSWORD_LENGTH_WARNING);
    }
}