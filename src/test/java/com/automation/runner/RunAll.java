package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/provider/features/login.feature",
                "src/test/java/provider/features/zCloseBrowser.feature",
        },
        glue = {
                "com.automation.login",
                "com.automation.close",
        }
        ,
        dryRun = false
//        tags = "",
//        plugin = {},
//        monochrome = true
)

public class RunAll {
}
