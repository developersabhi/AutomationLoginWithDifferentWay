package com.automation.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonMethod;
import utils.TestBase;

public class LoginTest extends CommonMethod {

    Logger logger = Logger.getLogger(LoginTest.class);
    Login login =new Login();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestBase.getWebDriver().get("https://www.win1buzz.in/login");
        logger.info("Navigated to login page :: "+getClass());
    }

    @When("verify the login functionality with invalid username {string} and invalid {string} and error message {string}")
    public void the_user_enters_username_and_password(String username, String password, String msg) {
       login.verifyLoginFunctionality(username,password,msg);
    }



}
