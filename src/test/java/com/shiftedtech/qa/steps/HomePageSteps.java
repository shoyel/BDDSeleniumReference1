package com.shiftedtech.qa.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by ShiftTeacher on 1/21/2018.
 */
public class HomePageSteps extends StepBase{

    @Then("^Spree home|Home page should display$")
    public void home_page_should_display() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Spree Demo Site", title);
    }

    @When("^User click login link$")
    public void user_click_login_link() throws Throwable {
        click(By.linkText("Login"));
    }


    @Then("^Login success message display$")
    public void login_success_message_display() throws Throwable {
        WebElement loginSuccessLabel = driver.findElement(By.xpath("//div[@id='content']/div[contains(@class,'alert-success')]"));
        String successText = loginSuccessLabel.getText();
        Assert.assertEquals("Logged in successfully",successText);
    }
}
