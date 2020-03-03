package pages;

import base.BasePage;
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

public class RegistrationPage extends BasePage {

    //HEADER
    @FindBy(how = How.LINK_TEXT, using = "SIIT OSC")
    private WebElement registrationPageSiitOscLink;
    @FindBy(how = How.ID, using = "login_open")
    private WebElement registrationPageLoginLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='nav']/child::li/a[contains(.,'Register')]")
    private WebElement registrationPageRegistrationHeaderLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement registrationPagePublishAd;

    //CONTENT
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='SIIT OSC']")
    private WebElement registrationPageSiitTitle;
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='Create a new account']")
    private WebElement registrationPageCreateAccountText;
    @FindBy(how = How.XPATH, using = "//div[@class='header']/h1")
    private WebElement registrationPageTitle;
    @FindBy(how = How.ID, using = "s_name")
    public WebElement registrationPageNameField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='name']")
    public WebElement registrationPageNameLabel;
    @FindBy(how = How.ID, using = "s_email")
    public WebElement registrationPageEmailField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='email']")
    public WebElement registrationPageEmailLabel;
    @FindBy(how = How.ID, using = "s_password")
    public WebElement registrationPagePasswordField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='password']")
    public WebElement registrationPagePasswordLabel;
    @FindBy(how = How.ID, using = "s_password2")
    public WebElement registrationPagePasswordRepeatField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='password-2']")
    public WebElement registrationPagePasswordRepeatLabel;
    @FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
    public WebElement registrationPageCreateButton;

    //FOOTER
    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement registrationPageLoginFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/child::li/a[contains(.,'Register')]")
    private WebElement registrationPageRegistrationFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement registrationPagePublishAdFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Contact")
    private WebElement registrationPageContactFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "classifieds scripts")
    private WebElement registrationPageClassifiedScriptsFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/div[contains(.,'This website is proudly using the ')]")
    private WebElement registrationPageFooterMessage;

    //WARNINGS
    @FindBy(how = How.XPATH, using = "//label[@for='s_email']")
    public WebElement registrationPageEmailWarning;
    @FindBy(how = How.XPATH, using = "//label[@for='s_name']")
    public WebElement registrationPageNameWarning;
    @FindBy(how = How.XPATH, using = "//label[@for='s_password']")
    public WebElement registrationPagePasswordWarning;
    @FindBy(how = How.XPATH, using = "//label[@for='s_password2']")
    public WebElement registrationPageSecondPasswordWarning;
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'The specified')]")
    public WebElement registrationPageEmailAlreadyInUse;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void setRegistrationPageNameField(String name) {
        setElementText(registrationPageNameField, name);
    }

    public void setRegistrationPageEmailField(String email) {
        setElementText(registrationPageEmailField, email);
    }

    public void setRegistrationPagePasswordField(String password) {
        setElementText(registrationPagePasswordField, password);
    }

    public void setRegistrationPagePasswordRepeatField(String passwordRepeat) {
        setElementText(registrationPagePasswordRepeatField, passwordRepeat);
    }

    public WebElement getRegistrationPageEmailWarning() {
        return registrationPageEmailWarning;
    }

    public WebElement getRegistrationPageNameWarning() {
        return registrationPageNameWarning;
    }

    public WebElement getRegistrationPagePasswordWarning() {
        return registrationPagePasswordWarning;
    }

    public WebElement getRegistrationPageSecondPasswordWarning() {
        return registrationPageSecondPasswordWarning;
    }

    public WebElement getRegistrationPageEmailAlreadyInUse() {
        return registrationPageEmailAlreadyInUse;
    }

    public void clickCreateButton() {
        clickElement(registrationPageCreateButton);
    }

    public void completeRegistrationForm(String name, String email, String password, String passwordRepeat) {
        setRegistrationPageNameField(name);
        setRegistrationPageEmailField(email);
        setRegistrationPagePasswordField(password);
        setRegistrationPagePasswordRepeatField(passwordRepeat);
        registrationPageCreateButton.click();
    }

    protected List<WebElement> elements() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(registrationPageSiitOscLink);
        elements.add(registrationPageLoginLink);
        elements.add(registrationPageRegistrationHeaderLink);
        elements.add(registrationPagePublishAd);
        elements.add(registrationPageSiitTitle);
        elements.add(registrationPageCreateAccountText);
        elements.add(registrationPageTitle);
        elements.add(registrationPageNameField);
        elements.add(registrationPageNameLabel);
        elements.add(registrationPageEmailField);
        elements.add(registrationPageEmailLabel);
        elements.add(registrationPagePasswordField);
        elements.add(registrationPagePasswordLabel);
        elements.add(registrationPagePasswordRepeatField);
        elements.add(registrationPagePasswordRepeatLabel);
        elements.add(registrationPageCreateButton);
        elements.add(registrationPageLoginFooterLink);
        elements.add(registrationPageRegistrationFooterLink);
        elements.add(registrationPagePublishAdFooterLink);
        elements.add(registrationPageContactFooterLink);
        elements.add(registrationPageClassifiedScriptsFooter);
        elements.add(registrationPageFooterMessage);
        return elements;
    }

    public boolean verifyElementsRegistrationPage() {
        Wait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.elements()));
        return true;
    }

}
