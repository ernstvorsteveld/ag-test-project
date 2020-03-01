package tests;

import base.SiitBaseTest;
import base.ValueGenerator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PasswordResetPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetPageTests extends SiitBaseTest {

    public static final String passwordResetUrl = PasswordResetPage.BASE_URL + "index.php?page=login&action=recover";

    private PasswordResetPage passwordResetPage;

    private static final String INVALID_EMAIL_WARNING = "x\nInvalid email address";
    private static final String NONEXISTENT_EMAIL_WARNING = "x\nWe were not able to identify you given the information provided";
    private static final String RESET_PASSWORD_EMAIL_INSTRUCTIONS = "x\nWe have sent you an email with the instructions to reset your password";

    @BeforeClass
    public void createPages() {
        passwordResetPage = new PasswordResetPage(driver);
    }

    @BeforeMethod
    public void set_up() {
        driver.get(passwordResetUrl);
        passwordResetPage.waitForPageLoaded();
    }

    @Test
    public void passwordReset() {
        GIVEN:
        //in before

        THEN:
        assertThat(passwordResetPage.verifyElementsPasswordResetPage()).isTrue();

        WHEN:
        passwordResetPage.clearField();

        AND:
        passwordResetPage.setEmailToResetPassword("HmuKIqJ@google.com");

        AND:
        passwordResetPage.clickSubmitButton();

        THEN:
        assertThat(passwordResetPage.getPasswordResetPageInstructionsEmailSent().getText()).isEqualTo(RESET_PASSWORD_EMAIL_INSTRUCTIONS);
    }

    @Test
    public void nonexistentFormatUsedForPasswordReset(){
        GIVEN:
        //in before

        WHEN:
        passwordResetPage.clearField();

        AND:
        passwordResetPage.setEmailToResetPassword(ValueGenerator.generateEmail(5, "@gmail.com"));

        AND:
        passwordResetPage.clickSubmitButton();

        THEN:
        assertThat(passwordResetPage.getPasswordResetPageNonexistentEmailWarning().getText()).isEqualTo(NONEXISTENT_EMAIL_WARNING);
    }

    @Test
    public void invalidEmailUsedForPasswordReset() {
        GIVEN:
        //in before

        WHEN:
        passwordResetPage.clearField();

        AND:
        passwordResetPage.setEmailToResetPassword(ValueGenerator.generateAlphabetic(8));

        AND:
        passwordResetPage.clickSubmitButton();

        THEN:
        assertThat(passwordResetPage.getPasswordResetPageInvalidEmailWarning().getText()).isEqualTo(INVALID_EMAIL_WARNING);
    }
}
