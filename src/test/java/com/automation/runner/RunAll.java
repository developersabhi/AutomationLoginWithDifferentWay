package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/provider/features/login.feature",
        },
        glue = {
                "com.automation.login",
        }
        ,
        dryRun = false
//        tags = "",
//        plugin = {},
//        monochrome = true
)

public class RunAll {
}
