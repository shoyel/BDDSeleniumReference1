package com.shiftedtech.qa.framework.scriptbase;

import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.pages.LoginPage;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import com.shiftedtech.qa.framework.utils.WebElementUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 1/7/2018.
 */
public class SpreeScriptBaseTestNg {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    protected LoginPage loginPage;


    @BeforeClass
    public void beforeClass() throws Exception {

    }

    @BeforeMethod
    public void beforeMethod() throws Exception {

        driver = DriverFactory.getInstance().getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        webElementUtils = new WebElementUtils();
        homePage = new HomePage();
        loginPage = new LoginPage();

        driver.navigate().to("http://spree.shiftedtech.com");

    }

    @AfterMethod
    public void afterMethod(){

        webElementUtils = null;
        homePage = null;
        loginPage = null;
        DriverFactory.getInstance().removeDriver();
    }

    public void delayFor(int timeInMili){
        //spree.getUtils().delayFor(timeInMili);
        homePage.delayFor(timeInMili);
    }

    //BeforeClass
    //BeforeMethod
    //Test
    //AfterMethod
    //BeforeMethod
    //Test
    //AfterMethod
    //AfterClass
}
