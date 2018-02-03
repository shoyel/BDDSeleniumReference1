package com.shiftedtech.qa.framework.steps;

import com.shiftedtech.qa.framework.steps.hook.StepBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by ShiftTeacher on 1/21/2018.
 */
public class ApplicationSteps extends StepBase {
    @Given("^Not a validated user$")
    public void not_a_validated_user() throws Throwable {
        driver.manage().deleteAllCookies();
    }

    @When("^User browse to the site$")
    public void user_browse_to_the_site() throws Throwable {
        driver.navigate().to("http://spree.shiftedtech.com");
    }
}
