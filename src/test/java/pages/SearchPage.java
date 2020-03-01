package pages;

import base.BasePage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    //HEADER
    @FindBy(how = How.LINK_TEXT, using = "SIIT OSC")
    private WebElement searchPageSiitOscLink;
    @FindBy(how = How.ID, using = "login_open")
    private WebElement searchPageLoginLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='nav']/child::li/a[contains(.,'Register')]")
    private WebElement searchPageRegistrationHeaderLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement searchPagePublishAd;

    //SEARCH FUNCTIONALITY
    @FindBy(how = How.XPATH, using = "//div[@class='has-placeholder input-text']")
    private WebElement searchPageSearchInputField;
    @FindBy(how = How.ID, using = "sCategory")
    public WebElement searchPageCategoryDropDown;
    @FindBy(how = How.XPATH, using = "//button[@class='ui-button ui-button-big js-submit']")
    private WebElement searchPageSearchButton;

    //FOOTER
    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement searchPageLoginFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/child::li/a[contains(.,'Register')]")
    private WebElement searchPageRegistrationFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    private WebElement searchPagePublishAdFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "Contact")
    private WebElement searchPageContactFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "classifieds scripts")
    private WebElement searchPageClassifiedScriptsFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/div[contains(.,'This website is proudly using the ')]")
    private WebElement searchPageFooterMessage;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSearchButton() {
        clickElement(searchPageSearchButton);
    }

    private List<WebElement> elementsSearchPage() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(searchPageSiitOscLink);
        elements.add(searchPageLoginLink);
        elements.add(searchPageRegistrationHeaderLink);
        elements.add(searchPagePublishAd);
        elements.add(searchPageSearchInputField);
        elements.add(searchPageCategoryDropDown);
        elements.add(searchPageSearchButton);
        elements.add(searchPageLoginFooterLink);
        elements.add(searchPageRegistrationFooterLink);
        elements.add(searchPagePublishAdFooterLink);
        elements.add(searchPageContactFooterLink);
        elements.add(searchPageClassifiedScriptsFooter);
        elements.add(searchPageFooterMessage);
        return elements;
    }

    public boolean verifyElementsSearchPage() {
        return elementsDisplayed(elementsSearchPage());
    }

    public void clearField() {
        searchPageSearchInputField.clear();
    }

    public void setSearchText(String searchText) {
        searchPageSearchInputField.sendKeys(searchText);
    }
}
