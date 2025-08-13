package com.automation.close;

import org.apache.log4j.Logger;
import utils.TestBase;


public class Close {
    Logger logger = Logger.getLogger(Close.class);

    public void close(){
        TestBase.getWebDriver().quit();
        logger.error("User not able the close the Browser");
    }
}
