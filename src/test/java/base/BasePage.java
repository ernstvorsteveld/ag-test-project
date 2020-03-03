package base;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static final String BASE_URL = "http://siit.atwebpages.com/osc/";
    private WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setElementText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public boolean elementsDisplayed(List<WebElement> allElements) {
        for (WebElement element : allElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean elementsEnabled(List<WebElement> allElements) {
        for (WebElement dropdown : allElements) {
            if (!dropdown.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    protected boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void withDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForPage() {
        Wait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements()));
    }

    protected abstract List<WebElement> elements();
}
