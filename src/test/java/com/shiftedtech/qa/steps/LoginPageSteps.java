package com.shiftedtech.qa.steps;

import com.google.common.base.Function;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 1/20/2018.
 */
public class LoginPageSteps extends StepBase{

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
