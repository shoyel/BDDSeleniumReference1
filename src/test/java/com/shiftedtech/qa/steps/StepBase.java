package com.shiftedtech.qa.steps;

import com.google.common.base.Function;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import cucumber.api.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 1/21/2018.
 */
public class StepBase {
    protected  WebDriver driver = DriverFactory.getInstance().getDriver();

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
