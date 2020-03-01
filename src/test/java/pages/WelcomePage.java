package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage {

    //LANDING_PAGE_AFTER_REGISTRATION_OR_LOGIN
    @FindBy(how = How.XPATH, using = "//span[contains(.,'Hi')]")
    private WebElement hiLoggedUser;
    @FindBy(how = How.ID, using = "flashmessage")
    private WebElement successfullyCreatedAccount;
    @FindBy(how = How.LINK_TEXT, using = "My account")
    private WebElement myAccountLink;
    @FindBy(how = How.LINK_TEXT, using = "Logout")
    private WebElement logoutLink;

    //SUCCESSFULLY_PUBLISH_AD
    @FindBy(how = How.ID, using = "flashmessage")
    private WebElement adPublishedSuccessfully;

    public WelcomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getHiLoggedUser() {
        return hiLoggedUser;
    }

    public void setHiLoggedUser(WebElement hiLoggedUser) {
        this.hiLoggedUser = hiLoggedUser;
    }

    public WebElement getSuccessfullyCreatedAccount() {
        return successfullyCreatedAccount;
    }

    public void setSuccessfullyCreatedAccount(WebElement successfullyCreatedAccount) {
        this.successfullyCreatedAccount = successfullyCreatedAccount;
    }

    public WebElement getAdPublishedSuccessfully() {
        return adPublishedSuccessfully;
    }

    public void clickLogoutLink() {
        clickElement(logoutLink);
    }

    public boolean isAccountLinkDisplayed() {
        return elementIsDisplayed(this.myAccountLink);
    }

    public boolean isLogoutLinkDisplayed() {
        return elementIsDisplayed(this.logoutLink);
    }
}
