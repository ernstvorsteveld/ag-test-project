package pages;

import base.BasePage;
import models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //HEADER
    @FindBy(how = How.LINK_TEXT, using = "SIIT OSC")
    private WebElement loginPageSiitOscLink;
    @FindBy(how = How.ID, using = "login_open")
    private WebElement loginPageLoginLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='nav']/child::li/a[contains(.,'Register')]")
    private WebElement loginPageRegistrationHeaderLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement loginPagePublishAd;

    //CONTENT
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='SIIT OSC']")
    private WebElement loginPageSiitTitle;
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='Login']")
    private WebElement loginPageLoginText;
    @FindBy(how = How.XPATH, using = "//div[@class='header']/h1")
    private WebElement loginPageTitle;
    @FindBy(how = How.ID, using = "email")
    private WebElement loginPageEmailField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='email']")
    private WebElement loginPageEmailLabel;
    @FindBy(how = How.ID, using = "password")
    private WebElement loginPagePasswordField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='password']")
    private WebElement loginPagePasswordLabel;
    @FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
    private WebElement loginPageLoginButton;
    @FindBy(how = How.XPATH, using = "//label[@for='remember']")
    private WebElement loginPageRememberMeLabel;
    @FindBy(how = How.ID, using = "remember")
    private WebElement loginPageRememberMeCheckbox;
    @FindBy(how = How.LINK_TEXT, using = "Forgot password?")
    private WebElement loginPageForgotPasswordLink;
    @FindBy(how = How.XPATH, using = "//div[@class='actions']/a[contains(.,'Register')]")
    private WebElement loginPageRegistrationContentLink;

    //FOOTER
    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement loginPageLoginFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/child::li/a[contains(.,'Register')]")
    private WebElement loginPageRegistrationFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement loginPagePublishAdFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Contact")
    private WebElement loginPageContactFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "classifieds scripts")
    private WebElement loginPageClassifiedScriptsFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/div[contains(.,'This website is proudly using the ')]")
    private WebElement loginPageFooterMessage;

    //WARNINGS
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'Please provide an email address')]")
    private WebElement loginPageEmailWarning;
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'Empty passwords are not allowed. Please provide a password')]")
    private WebElement loginPagePasswordWarning;
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'The user')]")
    private WebElement loginPageNonexistentUserWarning;
    @FindBy(how = How.XPATH, using = "//div[@class = 'flashmessage flashmessage-error'and contains(.,'The password is incorrect')]")
    private WebElement loginPageIncorrectPasswordWarning;
    @FindBy(how = How.XPATH, using = "//div[@class = 'flashmessage flashmessage-error'and contains(.,'Empty passwords are not allowed. Please provide a password')]")
    private WebElement loginPageMissingPasswordWarning;
    @FindBy(how = How.XPATH, using = "//div[@class = 'flashmessage flashmessage-error'and contains(.,'The user')]")
    private WebElement loginPageIncorrectEmailWarning;
    @FindBy(how = How.XPATH, using = "//div[@class = 'flashmessage flashmessage-error'and contains(.,'Please provide an email address')]")
    private WebElement loginPageMissingEmailWarning;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getLoginPageEmailWarning() {
        return loginPageEmailWarning;
    }

    public WebElement getLoginPagePasswordWarning() {
        return loginPagePasswordWarning;
    }

    public WebElement getLoginPageNonexistentUserWarning() {
        return loginPageNonexistentUserWarning;
    }

    public WebElement getLoginPageIncorrectPasswordWarning() {
        return loginPageIncorrectPasswordWarning;
    }

    public WebElement getLoginPageMissingPasswordWarning() {
        return loginPageMissingPasswordWarning;
    }

    public WebElement getLoginPageIncorrectEmailWarning() {
        return loginPageIncorrectEmailWarning;
    }

    public WebElement getLoginPageMissingEmailWarning() {
        return loginPageMissingEmailWarning;
    }

    public void clickLoginButton() {
        clickElement(loginPageLoginButton);
    }

    public void login(LoginModel loginModel) {
        loginPageEmailField.clear();
        loginPageEmailField.sendKeys(loginModel.getEmail());

        loginPagePasswordField.clear();
        loginPagePasswordField.sendKeys(loginModel.getPassword());

        loginPageLoginButton.click();
    }

    private List<WebElement> elements() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(loginPageSiitOscLink);
        elements.add(loginPageLoginLink);
        elements.add(loginPageRegistrationHeaderLink);
        elements.add(loginPagePublishAd);
        elements.add(loginPageSiitTitle);
        elements.add(loginPageLoginText);
        elements.add(loginPageTitle);
        elements.add(loginPageEmailLabel);
        elements.add(loginPageEmailField);
        elements.add(loginPagePasswordField);
        elements.add(loginPagePasswordLabel);
        elements.add(loginPageLoginButton);
        elements.add(loginPageRememberMeLabel);
        elements.add(loginPageRememberMeCheckbox);
        elements.add(loginPageForgotPasswordLink);
        elements.add(loginPageRegistrationContentLink);
        elements.add(loginPageLoginFooterLink);
        elements.add(loginPageRegistrationFooterLink);
        elements.add(loginPagePublishAdFooterLink);
        elements.add(loginPageContactFooterLink);
        elements.add(loginPageClassifiedScriptsFooter);
        elements.add(loginPageFooterMessage);
        return elements;
    }

    public void waitForPage() {
        Wait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements()));
    }

    public void clearFields() {
        loginPageEmailField.clear();
        loginPagePasswordField.clear();
    }

    public void setUsernameAndPassword(String email, String password) {
        loginPageEmailField.sendKeys(email);
        loginPagePasswordField.sendKeys(password);
    }

    public boolean isLoginLinkDisplayed() {
        return elementIsDisplayed(this.loginPageLoginLink);
    }

    public boolean isLoginEmailFieldDisplayed() {
        return elementIsDisplayed(this.loginPageEmailField);
    }

    public boolean isLoginPasswordFieldDisplayed() {
        return elementIsDisplayed(this.loginPagePasswordField);
    }

}
