package com.shiftedtech.qa.framework.scriptbase;

import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.pages.LoginPage;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import com.shiftedtech.qa.framework.utils.WebElementUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 1/7/2018.
 */
public class SpreeScriptBaseJUnit {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameterized.Parameter()
    public String browserName = "chrome";

    @Before
    public void beforeMethod() throws Exception {
        System.out.println("Browser: " + browserName);
        driver = DriverFactory.getInstance(browserName).getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        webElementUtils = new WebElementUtils();
        homePage = new HomePage();
        loginPage = new LoginPage();

        driver.navigate().to("http://spree.shiftedtech.com");

    }

    @After
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

    @Parameterized.Parameters(name = "{index} - Browser - {0}")
    public static Collection<Object[]> browsers(){
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"},
                {"cloud_chrome_64"},
                {"cloud_ie_11"}
        });
    }
}
