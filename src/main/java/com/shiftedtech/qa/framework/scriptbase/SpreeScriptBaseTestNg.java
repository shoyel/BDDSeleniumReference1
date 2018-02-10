package com.shiftedtech.qa.framework.scriptbase;

import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.pages.LoginPage;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import com.shiftedtech.qa.framework.utils.WebElementUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 1/7/2018.
 */
public class SpreeScriptBaseTestNg {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    protected LoginPage loginPage;


    @BeforeMethod
    @Parameters({"browserName"})
    public void beforeMethod(@Optional(value = "grid_firefox_16") String browserName) throws Exception {
        driver = DriverFactory.getInstance(browserName).getDriver();
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
