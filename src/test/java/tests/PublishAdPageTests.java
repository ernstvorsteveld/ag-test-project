package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.SiitBaseTest;
import base.ValueGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PublishAdPage;
import pages.WelcomePage;

public class PublishAdPageTests extends SiitBaseTest {

    private static final String AD_PUBLISHED_SUCCESSFULLY = "x\nYour listing has been published";
    private static final String MISSING_REGION_WARNING = "Select a region.";
    private static final String MISSING_EMAIL_WARNING = "Email: this field is required.";
    public static final String ItemAddPageUrl = PublishAdPage.BASE_URL + "index.php?page=item&action=item_add";
    private PublishAdPage publishAdPage;
    private WelcomePage welcomePage;

    @BeforeClass
    public void set_up() {
        publishAdPage = new PublishAdPage(driver);
        welcomePage = new WelcomePage(driver);
    }

    @BeforeMethod
    public void go_to_item_add_page() {
        driver.get(ItemAddPageUrl);
        publishAdPage.waitForPage();
    }

    @Test
    public void should_show_all_elements() {
        GIVEN:
        // in BeforeMethod

        THEN:
        assertThat(publishAdPage.verifyElements()).isTrue();
    }

    @Test
    public void should_publish_add_without_uploading_image() {
        GIVEN:
        //in BeforeMethod

        WHEN:
        publishAdPage.selectCategory("9");

        AND:
        publishAdPage.selectCurrency("EUR");

        AND:
        publishAdPage.selectRegion("782161");

        AND:
        publishAdPage.waitForCities();
        publishAdPage.selectCity("463301");

        AND:
        completeFormData();

        AND:
        publishAdPage.clickPublishButton();

        THEN:
        assertThat(welcomePage.getAdPublishedSuccessfully().getText()).isEqualTo(AD_PUBLISHED_SUCCESSFULLY);
    }

    private void completeFormData() {
        publishAdPage
                .completeFormData(ValueGenerator.generateAlphabetic(8), ValueGenerator.generateAlphabetic(20),
                        ValueGenerator.generateNumeric(3), ValueGenerator.generateAlphabetic(8),
                        ValueGenerator.generateAlphabetic(15), ValueGenerator.generateAlphabetic(7),
                        ValueGenerator.generateEmail(5, "@gmail.com"));
    }

    @Test
    public void publishAdWithImage() {
    }

    @Test
    public void validateMandatoryFieldsForPublishAdPage() {
    }

    @Test
    public void publishAdAndCheckListingPageDisplay() {
    }

    @Test
    public void publishAdFromUserAccount() {
    }

    @Test
    public void publishAdNoCategorySelected() {
    }

    @Test
    public void publishAdNoTitle() {
    }

    @Test
    public void publishAdNoDescription() {
    }

    @Test
    public void publishAdNoPrice() {
    }

    @Test
    public void publishAdNoRegionSelected() {
    }

    @Test
    public void publishAdNoCitySelected() {
    }

    @Test
    public void publishAdNoCityArea() {
    }

    @Test
    public void publishAdNoAddress() {
    }

    @Test
    public void publishAdNoName() {
    }

    @Test
    public void publishAdNoEmail() {
    }

}