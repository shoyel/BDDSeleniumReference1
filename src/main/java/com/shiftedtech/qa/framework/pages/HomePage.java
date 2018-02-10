package com.shiftedtech.qa.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ShiftTeacher on 12/17/2017.
 */
public class HomePage extends PageBase {

    @FindBy(how= How.LINK_TEXT, using= "Login" )
    private WebElement loginLink;
    @FindBy(how= How.LINK_TEXT, using= "Logout" )
    private WebElement logoutLink;
    @FindBy(xpath = "//div[@id='content']/div[contains(@class,'alert-success')]")
    private WebElement successMsg;

    public HomePage(){
        super();
        PageFactory.initElements(driver,this);
    }

    public void navigateToLoginPage(){
        loginLink.click();
    }

    public void logOut(){
        logoutLink.click();
    }

    public void verifyPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Spree Demo Site", title);

    }
    public void verifyLoginSuccess(){
        String successText = successMsg.getText();
        Assert.assertEquals("Logged in successfully",successText);
    }

}
