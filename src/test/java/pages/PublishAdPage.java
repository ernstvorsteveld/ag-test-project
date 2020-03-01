package pages;

import base.BasePage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublishAdPage extends BasePage {

    //HEADER
    @FindBy(how = How.LINK_TEXT, using = "SIIT OSC")
    public WebElement siitOscLink;
    //need to add registration+login link!!!!!
    @FindBy(how = How.LINK_TEXT, using = "Publish your ad for free")
    public WebElement publishAd;

    //CONTENT
    //General Information
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='SIIT OSC']")
    public WebElement siitTitle;
    @FindBy(how = How.XPATH, using = "//span[@itemprop='title' and .='Publish a listing']")
    public WebElement publishListingText;
    @FindBy(how = How.XPATH, using = "//div[@class='header']/h1")
    public WebElement title;
    @FindBy(how = How.XPATH, using = "//form[@id='item-post']/fieldset/h2")
    public WebElement generalInformationText;
    @FindBy(how = How.ID, using = "catId")
    public WebElement categoryDropDown;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='select_1']")
    public WebElement categoryLabel;
    @FindBy(how = How.ID, using = "titleen_US")
    public WebElement titleField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='title[en_US]']")
    public WebElement titleLabel;
    @FindBy(how = How.ID, using = "descriptionen_US")
    public WebElement descriptionField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='description[en_US]']")
    public WebElement descriptionLabel;
    @FindBy(how = How.ID, using = "price")
    public WebElement priceField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='price']")
    public WebElement priceLabel;
    @FindBy(how = How.ID, using = "currency")
    public WebElement currencyDropDown;
    @FindBy(how = How.ID, using = "restricted-fine-uploader")
    public WebElement imageUploader;
    //Listing Location
    @FindBy(how = How.XPATH, using = "//div[@class='box location']/h2")
    public WebElement listingLocationTitle;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='region']")
    public WebElement regionLabel;
    @FindBy(how = How.ID, using = "regionId")
    public WebElement regionDropDown;
    @FindBy(how = How.ID, using = "cityId")
    public WebElement cityDropDown; //enabled only after selecting a region from the regionDropDown
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='city']")
    public WebElement cityLabel;
    @FindBy(how = How.ID, using = "cityArea")
    public WebElement cityField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='cityArea']")
    public WebElement cityAreaLabel;
    @FindBy(how = How.ID, using = "address")
    public WebElement addressField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='address']")
    public WebElement addressLabel;
    //Seller's Information
    @FindBy(how = How.XPATH, using = "//div[@class='box seller_info']/h2")
    public WebElement sellerInformationTitle;
    @FindBy(how = How.ID, using = "contactName")
    public WebElement sellerNameField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='contactName']")
    public WebElement sellerNameLabel;
    @FindBy(how = How.ID, using = "contactEmail")
    public WebElement sellerEmailField;
    @FindBy(how = How.XPATH, using = "//label[@class='control-label' and @for='contactEmail']")
    public WebElement sellerEmailLabel;
    @FindBy(how = How.ID, using = "showEmail")
    public WebElement showEmailCheckBox;
    @FindBy(how = How.XPATH, using = "//label[@for='showEmail']")
    public WebElement showEmailCheckboxLabel;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement publishButton;

    //FOOTER
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/li/a[contains(.,'Login')]")
    public WebElement loginFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/li/a[contains(.,'Register')]")
    public WebElement registrationFooterLink;
    @FindBy(how = How.XPATH, using = "//ul[@class='resp-toggle']/li/a[contains(.,'Publish your')]")
    public WebElement publishFooterLink;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/ul[2]/li[contains(.,'Contact')]")
    public WebElement contactFooterLink;
    @FindBy(how = How.LINK_TEXT, using = "classifieds scripts")
    public WebElement classifiedScriptsFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='wrapper']/div[contains(.,'This website is proudly using the ')]")
    public WebElement footerMessage;

    //WARNINGS
    @FindBy(how = How.XPATH, using = "//label[@for='catId']")
    public WebElement categorySelectionWarning;
    @FindBy(how = How.XPATH, using = "//ul[@id='error_list']/li/label[@for='contactEmail']")
    public WebElement emailRequiredWarning;

    //Title too short / Description too short
    @FindBy(id = "flashmessage")
    private List<WebElement> warnings;

    public PublishAdPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getWarnings() {
        return warnings;
    }

    public void clickPublishButton() {
        clickElement(publishButton);
    }

    private List<WebElement> elements() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(siitOscLink);
        elements.add(publishAd);
        elements.add(siitTitle);
        elements.add(publishListingText);
        elements.add(title);
        elements.add(generalInformationText);
        elements.add(categoryLabel);
        elements.add(titleLabel);
        elements.add(descriptionLabel);
        elements.add(priceLabel);
        elements.add(listingLocationTitle);
        elements.add(regionLabel);
        elements.add(cityLabel);
        elements.add(cityAreaLabel);
        elements.add(addressLabel);
        elements.add(sellerInformationTitle);
        elements.add(sellerNameLabel);
        elements.add(sellerEmailLabel);
        elements.add(showEmailCheckboxLabel);
        elements.add(loginFooterLink);
        elements.add(registrationFooterLink);
        elements.add(publishFooterLink);
        elements.add(contactFooterLink);
        elements.add(classifiedScriptsFooter);
        elements.add(footerMessage);
        return elements;
    }

    public boolean verifyElements() {
        Wait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements()));
        return true;
    }

    public void completeFormData(
            String title,
            String description,
            String price,
            String city,
            String address,
            String name,
            String email) {
        titleField.sendKeys(title);
        descriptionField.sendKeys(description);
        priceField.sendKeys(price);
        cityField.sendKeys(city);
        addressField.sendKeys(address);
        sellerNameField.sendKeys(name);
        sellerEmailField.sendKeys(email);
    }

    private void wait(WebDriver driver, WebElement element, By by) {
        Wait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, by));
    }

    public void waitForCities() {
        wait(getDriver(), this.cityDropDown, By.xpath("//option[@value='463301']"));
    }

    public void selectCategory(String value) {
        selectValue(this.categoryDropDown, value);
    }

    private void selectValue(WebElement element, String value) {
        Select selectCategoryDropdown = new Select(element);
        selectCategoryDropdown.selectByValue(value);
    }

    public void selectCurrency(String value) {
        selectValue(this.currencyDropDown, value);
    }

    public void selectRegion(String value) {
        Select selectRegionDropdown = new Select(this.regionDropDown);
        selectRegionDropdown.selectByValue(value);
    }

    public void selectCity(String value) {
        selectValue(this.cityDropDown, value);
    }
}




