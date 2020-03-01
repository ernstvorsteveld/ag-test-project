package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage extends BasePage {

    //HEADER
    @FindBy(how = How.LINK_TEXT, using = "SIIT OSC")
    private WebElement passwordResetPageSiitOscLink;
    @FindBy(how = How.ID, using = "login_open")
    private WebElement passwordResetPageLoginLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='nav']/child::li/a[contains(.,'Register')]")
    private WebElement passwordResetRegistrationHeaderLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement passwordResetPagePublishAd;

    //CONTENT
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='SIIT OSC']")
    private WebElement passwordResetPageSiitTitle;
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='Recover password']")
    private WebElement passwordResetPageCreateAccountText;
    @FindBy(how = How.XPATH, using = "//div[@class='header']/h1")
    private WebElement passwordResetPageTitle;
    @FindBy(how = How.ID, using = "s_email")
    public WebElement passwordResetPageEmailField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='email']")
    private WebElement passwordResetPageEmailLabel;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement passwordResetPageSubmitButton;

    //FOOTER
    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement passwordResetPageLoginFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/child::li/a[contains(.,'Register')]")
    private WebElement passwordResetPageRegistrationFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement passwordResetPagePublishAdFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Contact")
    private WebElement passwordResetPageContactFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "classifieds scripts")
    private WebElement passwordResetPageClassifiedScriptsFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/div[contains(.,'This website is proudly using the ')]")
    private WebElement passwordResetPageFooterMessage;

    //WARNINGS
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'Invalid email')]")
    public WebElement passwordResetPageInvalidEmailWarning;
    @FindBy(how = How.XPATH, using = "//div[@class='flashmessage flashmessage-error'and contains(.,'We were not able')]")
    public WebElement passwordResetPageNonexistentEmailWarning;
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement passwordResetPageInstructionsEmailSent;

    //MESSAGES
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement passwordResetPageConfirmationMessage;

    public PasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getPasswordResetPageEmailField() {
        return passwordResetPageEmailField;
    }

    public WebElement getPasswordResetPageConfirmationMessage() {
        return passwordResetPageConfirmationMessage;
    }

    public WebElement getPasswordResetPageInvalidEmailWarning() {
        return passwordResetPageInvalidEmailWarning;
    }

    public WebElement getPasswordResetPageNonexistentEmailWarning() {
        return passwordResetPageNonexistentEmailWarning;
    }

    public WebElement getPasswordResetPageInstructionsEmailSent() {
        return passwordResetPageInstructionsEmailSent;
    }

    public void clickSubmitButton() {
        clickElement(passwordResetPageSubmitButton);
    }

    private List<WebElement> elementsPasswordResetPage() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(passwordResetPageSiitOscLink);
        elements.add(passwordResetPageLoginLink);
        elements.add(passwordResetRegistrationHeaderLink);
        elements.add(passwordResetPagePublishAd);
        elements.add(passwordResetPageSiitTitle);
        elements.add(passwordResetPageCreateAccountText);
        elements.add(passwordResetPageTitle);
        elements.add(passwordResetPageEmailField);
        elements.add(passwordResetPageEmailLabel);
        elements.add(passwordResetPageSubmitButton);
        elements.add(passwordResetPageLoginFooterLink);
        elements.add(passwordResetPageRegistrationFooterLink);
        elements.add(passwordResetPagePublishAdFooterLink);
        elements.add(passwordResetPageContactFooterLink);
        elements.add(passwordResetPageClassifiedScriptsFooter);
        elements.add(passwordResetPageFooterMessage);
        return elements;
    }

    public boolean verifyElementsPasswordResetPage() {
        return elementsDisplayed(elementsPasswordResetPage());
    }

    public void clearField() {
        passwordResetPageEmailField.clear();
    }

    public void setEmailToResetPassword(String email) {
        passwordResetPageEmailField.sendKeys(email);
    }
}
