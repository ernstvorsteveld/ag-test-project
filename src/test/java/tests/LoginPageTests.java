package tests;

import base.SiitBaseTest;
import base.ValueGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTests extends SiitBaseTest {

    public static final String loginUrl = LoginPage.BASE_URL + "index.php?page=login";

    private WelcomePage welcomePage;
    private LoginPage loginPage;

    private ObjectMapper mapper = new ObjectMapper();

    private static final String INCORRECT_PASSWORD_WARNING = "x\nThe password is incorrect";
    private static final String MISSING_PASSWORD_WARNING = "x\nEmpty passwords are not allowed. Please provide a password";
    private static final String INCORRECT_EMAIL_WARNING = "x\nThe user doesn't exist";
    private static final String MISSING_EMAIL_WARNING = "x\nPlease provide an email address";

    @DataProvider(name = "JSONDataProviderMoreFilesCollection")
    public Iterator<Object[]> jsonDataProviderCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File[] files = getListOfFilesFromResources("json");

        for (File f : files) {
            LoginModel m = mapper.readValue(f, LoginModel.class);
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(driver);
        welcomePage = new WelcomePage(driver);
    }

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get(loginUrl);
        loginPage.waitForPage();
    }

    @Test(dataProvider = "JSONDataProviderMoreFilesCollection")
    public void loginTest(LoginModel loginModel) {
        GIVEN:
        //in before

        WHEN:
        loginPage.login(loginModel);

        THEN:
        assertThat(welcomePage.isAccountLinkDisplayed()).isTrue();
        welcomePage.clickLogoutLink();
    }

    @Test(dataProvider = "JSONDataProviderMoreFilesCollection")
    public void logoutTest(LoginModel loginModel) {
        GIVEN:
        //in before

        WHEN:
        loginPage.login(loginModel);

        AND:
        welcomePage.clickLogoutLink();

        THEN:
        assertThat(loginPage.isLoginLinkDisplayed()).isTrue();
    }

    @Test
    public void validateMandatoryFieldsForLogin() {
        GIVEN:
        //in before

        WHEN:
        loginPage.clearFields();

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageEmailWarning().getText()).isEqualTo(MISSING_EMAIL_WARNING);
        assertThat(loginPage.getLoginPagePasswordWarning().getText()).isEqualTo(MISSING_PASSWORD_WARNING);
    }

    @Test
    public void loginWithNonexistentUser() {
        GIVEN:
        //in before

        WHEN:
        loginPage.clearFields();

        AND:
        loginPage.setUsernameAndPassword(ValueGenerator.generateAlphabetic(8), ValueGenerator.generateAlphabetic(8));

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageNonexistentUserWarning().getText()).isEqualTo(INCORRECT_EMAIL_WARNING);
    }

    @Test
    public void loginWithIncorrectPassword() {
        GIVEN:
        //in before

        WHEN:
        loginPage.setUsernameAndPassword("mimi@mimi.com", "asd");

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageIncorrectPasswordWarning().getText()).isEqualTo(INCORRECT_PASSWORD_WARNING);
    }

    @Test
    public void loginWithMissingPassword() {
        GIVEN:
        //in before

        WHEN:
        loginPage.setUsernameAndPassword("mimi@mimi.com", "");

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageMissingPasswordWarning().getText()).isEqualTo(MISSING_PASSWORD_WARNING);
    }

    @Test
    public void loginWithIncorrectEmail() {
        GIVEN:
        //in before

        WHEN:
        loginPage.setUsernameAndPassword("mimi2@mimi2.com", "aq12AQ!@");

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageIncorrectEmailWarning().getText()).isEqualTo(INCORRECT_EMAIL_WARNING);
    }

    @Test
    public void loginWithMissingEmail() {
        GIVEN:
        //in before

        WHEN:
        loginPage.setUsernameAndPassword("", "aq12AQ!@");

        AND:
        loginPage.clickLoginButton();

        THEN:
        assertThat(loginPage.getLoginPageMissingEmailWarning().getText()).isEqualTo(MISSING_EMAIL_WARNING);
    }

    @Test(dataProvider = "JSONDataProviderMoreFilesCollection")
    public void loginLogoutAndPressBackButton(LoginModel loginModel) {
        GIVEN:
        //in before

        WHEN:
        loginPage.login(loginModel);

        THEN:
        assertThat(welcomePage.isLogoutLinkDisplayed()).isTrue();

        WHEN:
        welcomePage.clickLogoutLink();

        THEN:
        assertThat(loginPage.isLoginLinkDisplayed()).isTrue();

        WHEN:
        driver.navigate().back();

        THEN:
        assertThat(loginPage.isLoginEmailFieldDisplayed()).isTrue();
        assertThat(loginPage.isLoginPasswordFieldDisplayed()).isTrue();
    }
}