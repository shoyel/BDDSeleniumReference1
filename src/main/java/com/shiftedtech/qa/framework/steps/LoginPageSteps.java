package com.shiftedtech.qa.framework.steps;

import com.shiftedtech.qa.framework.steps.hook.StepBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

/**
 * Created by ShiftTeacher on 1/20/2018.
 */
public class LoginPageSteps extends StepBase {

    @Then("^Browser display Login page$")
    public void browser_display_Login_page() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Login - Spree Demo Site", title);
    }

    @When("^User enter user email as \"([^\"]*)\"$")
    public void user_enter_user_email_as(String email) throws Throwable {
        typeText(By.id("spree_user_email"), email);
    }

    @When("^User enter password as \"([^\"]*)\"$")
    public void user_enter_password_as(String password) throws Throwable {
        typeText(By.id("spree_user_password"), password);
    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        click(By.xpath("//input[@name='commit']"));
    }
}
