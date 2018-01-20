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
public class LoginSteps {

    private WebDriver driver;


    @Before
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
       driver.close();
       driver.quit();
    }

    @Given("^Not a validated user$")
    public void not_a_validated_user() throws Throwable {
        driver.manage().deleteAllCookies();
    }

    @When("^User browse to the site$")
    public void user_browse_to_the_site() throws Throwable {
        driver.navigate().to("http://spree.shiftedtech.com");
    }

    @Then("^Spree home page display$")
    public void spree_home_page_display() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Spree Demo Site", title);
    }

    @When("^User click login link$")
    public void user_click_login_link() throws Throwable {
        click(By.linkText("Login"));
    }

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

    @Then("^Home page should display$")
    public void home_page_should_display() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Spree Demo Site", title);
    }

    @Then("^Login success message display$")
    public void login_success_message_display() throws Throwable {
        WebElement loginSuccessLabel = driver.findElement(By.xpath("//div[@id='content']/div[contains(@class,'alert-success')]"));
        String successText = loginSuccessLabel.getText();
        Assert.assertEquals("Logged in successfully",successText);
    }

    public void typeText(By by, String text) {

        WebElement element = waitForElementDisplayed(by, 30);
        highlight(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By by) {
        WebElement element = waitForElementDisplayed(by, 30);
        highlight(element);
        element.click();
    }

    public void delayFor(int timeInMili) {
        try {
            Thread.sleep(timeInMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(200);
        }
    }

    public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSec) {

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element != null && element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
        return foo;
    }
}
