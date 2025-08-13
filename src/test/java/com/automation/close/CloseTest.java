package com.automation.close;

import io.cucumber.java.en.Then;

public class CloseTest {

    Close close =  new Close();
    @Then("User will logout and close the browser.")
    public void user_will_logout_and_close_the_browser() {
        close.close();
    }
}
