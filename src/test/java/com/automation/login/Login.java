package com.automation.login;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtil;
import utils.CommonMethod;
import utils.TestBase;

import org.apache.log4j.Logger;

public class Login extends BaseUtil {

    Logger logger= Logger.getLogger(Login.class);
    CommonMethod commonMethod = new CommonMethod();
    private String acturalUsernameMsg;
    private String acturalPasswordMsg;

    public Login() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    @FindBy(xpath ="//input[@placeholder='Enter Login ID']" )
    WebElement usernameInputField;
    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    WebElement passwordInputField;
    @FindBy(xpath= "//input[@placeholder='Enter Login ID']/following-sibling::p")
    WebElement usernameError;
    @FindBy(xpath= "//div[@class='passwoed-icon']/following-sibling::p")
    WebElement passwordError;
    @FindBy(xpath = "//div[@class='passwoed-icon']/following::p[contains(text(),'Invalid email or password.')]")
    WebElement passwordErrorInvalidMessage;
    @FindBy(xpath = "//div[@class='notify-justify-btn']//button[contains(text(),'Cancel')]")
    WebElement notificationCancelBtn;
    @FindBy(xpath = "//button[@class='log_out_top']")
    WebElement topLogoutBtn;


    public void enterUsername(String username){
        enterText(usernameInputField, username);
    }
    public void enterPassword(String password){
        enterText(passwordInputField,password);
    }

//    public String getErrorMessage(String expectedMessage) {
//        commonMethod.explicitWait(2000);
//        if (isElementDisplayed(usernameError) && usernameError.getText().trim().equals(expectedMessage)) {
//            return usernameError.getText().trim();
//        } else if (isElementDisplayed(passwordError) && passwordError.getText().trim().equals(expectedMessage)) {
//            return passwordError.getText().trim();
//        } else {
//            if (isElementDisplayed(usernameError)) {
//                return usernameError.getText().trim();
//            }
//            if (isElementDisplayed(passwordError)) {
//                return passwordError.getText().trim();
//            }
//            return "No error message found";
//        }
//    }

    public void verifyLoginFunctionality(String username,String password,String expectedMsg){
        try{
                commonMethod.waitForVisibleElement(usernameInputField);
                commonMethod.waitForVisibleElement(passwordInputField);
                enterUsername(username);
                enterPassword(password);
                commonMethod.clickOnButton("Login");
                commonMethod.explicitWait(1000);
//                String actualUsernameMsg ="";

                switch (expectedMsg){
                    case "Invalid login ID":
                        acturalUsernameMsg = usernameError.getText();
                        Assert.assertEquals("Error message not expected ",acturalUsernameMsg , expectedMsg);
                        break;
                    case "Invalid email or password.":
                        commonMethod.explicitWait(1000);
                        acturalPasswordMsg = passwordErrorInvalidMessage.getText();
                        Assert.assertEquals("Error message not expected ",acturalPasswordMsg , expectedMsg);
                        break;
                    case "Login ID field is required":
                        acturalUsernameMsg = usernameError.getText();
                        Assert.assertEquals("Error message not expected ",acturalUsernameMsg , expectedMsg);
                        break;
                    case "Password field is required":
                        acturalPasswordMsg = passwordError.getText();
                        Assert.assertEquals("Error Message not as expected ::",acturalPasswordMsg, expectedMsg);
                        break;
                    case "Login ID field is required & Password field is required":
                        if(username.isEmpty() && password.isEmpty()){
                        acturalUsernameMsg = usernameError.getText();
                        acturalPasswordMsg = passwordError.getText();
                            Assert.assertEquals("Error message for empty username is not correct", "Login ID field is required", acturalUsernameMsg);
                            Assert.assertEquals("Error message for empty password is not correct", "Password field is required", acturalPasswordMsg);
                        } else {
                            Assert.fail("Expected both 'Login ID field is required' and 'Password field is required', but fields are not empty.");
                        }
                    case "":
                        commonMethod.clickOnButton("Cancel");
                        commonMethod.explicitWait(1000);
                        commonMethod.clickOnButton("Logout");
                    default:
                        logger.error("Error message not match :: "+getClass());

                }
        }catch (Exception e){
                    logger.error(e.getMessage() +"  "+getClass());
        }
    }
}
