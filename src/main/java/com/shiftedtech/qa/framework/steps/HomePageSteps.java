package com.shiftedtech.qa.framework.steps;

import com.shiftedtech.qa.framework.steps.hook.StepBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ShiftTeacher on 1/21/2018.
 */
public class HomePageSteps extends StepBase {
    //protected HomePage homePage = new HomePage();

    @Then("^Spree home|Home page should display$")
    public void home_page_should_display() throws Throwable {
        //String title = driver.getTitle();
       // Assert.assertEquals("Spree Demo Site", title);
        homePage.verifyPageTitle();
    }

    @When("^User click login link$")
    public void user_click_login_link() throws Throwable {
       // click(By.linkText("Login"));
        homePage.navigateToLoginPage();
    }


    @Then("^Login success message display$")
    public void login_success_message_display() throws Throwable {
        //WebElement loginSuccessLabel = driver.findElement(By.xpath("//div[@id='content']/div[contains(@class,'alert-success')]"));
       // String successText = loginSuccessLabel.getText();
       // Assert.assertEquals("Logged in successfully",successText);

        homePage.verifyLoginSuccess();
    }
}
