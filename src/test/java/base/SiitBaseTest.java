package base;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class SiitBaseTest {

    protected WebDriver driver;

    @BeforeClass
    protected void initDriver() {
//        System.setProperty("webdriver.chrome.logfile", "/tmp/chromedriver.log");
//        System.setProperty("webdriver.chrome.verboseLogging", "true");
        driver = WebDriverFactory.getDriver(Browser.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    protected File[] getListOfFilesFromResources(String directoryName) throws UnsupportedEncodingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(URLDecoder.decode(classLoader.getResource(directoryName).getPath(), "UTF-8"));
        File[] files = directory.listFiles();
        System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }

}
