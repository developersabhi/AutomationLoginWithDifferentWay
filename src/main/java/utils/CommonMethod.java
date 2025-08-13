package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethod {

    WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), Duration.ofMillis(10000));
    private static final Logger logger = Logger.getLogger(CommonMethod.class);
    private static final TestBase testBase = TestBase.getInstance();

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement logiBtn;
    @FindBy(xpath = "//div[@class='notify-justify-btn']//button[contains(text(),'Cancel')]")
    WebElement notificationCancelBtn;
    @FindBy(xpath = "//button[@class='log_out_top']")
    WebElement topLogoutBtn;

    public CommonMethod() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    public static TestBase getTestBase(){
        return new TestBase();
    }

    public void explicitWait(long time) {
        try {
            logger.info("Waiting for " + time);
            Thread.sleep(time);
        } catch (Exception e) {
            logger.error("Getting error while doing explicit wait:: " + e.getMessage());
        }
    }
    public void waitForVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickOnButton(String button){
        switch (button.toUpperCase()){
            case "LOGIN":
                waitForVisibleElement(logiBtn);
                explicitWait(2000);
                logiBtn.click();
                break;
            case "CANCEL":
                waitForVisibleElement(notificationCancelBtn);
                notificationCancelBtn.click();
                break;
            case "LOGOUT":
                waitForVisibleElement(topLogoutBtn);
                topLogoutBtn.click();
                break;
            default:
                logger.error("Button not click or not found :: "+getClass());
        }
    }
}
