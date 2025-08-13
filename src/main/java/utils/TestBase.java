package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    private static TestBase instance;
    static protected WebDriver driver = null;
    private static final Logger logger = Logger.getLogger(TestBase.class);

    public static TestBase getInstance(){
        if(instance==null){
            instance = new TestBase();
        }
        return instance;
    }

    TestBase(){
        init();
    }

    public void init(){
        try {
            if (driver == null){
                ChromeOptions options =new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notification");
                driver = new ChromeDriver(options);
            }
        }catch (Exception e){
            logger.error("Driver not init ::"+getClass()+" "+e.getMessage());
        }
    }

    public static WebDriver getWebDriver(){
        return driver;
    }
}
