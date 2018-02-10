package com.shiftedtech.qa.testng.functional;

import com.shiftedtech.qa.framework.scriptbase.SpreeScriptBaseTestNg;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 1/7/2018.
 */
public class SpreeLoginFunctionalityTestNg extends SpreeScriptBaseTestNg {

    @Test
    public void verifySuccessfullLogin(){
        homePage.verifyPageTitle("Spree Demo Site");
        homePage.navigateToLoginPage();
        loginPage.verifyPageTitle("Login - Spree Demo Site");
        loginPage.login("shiftqa01@gmail.com", "shiftedtech");
        homePage.verifyLoginSuccess();
        homePage.logOut();
    }

    //@Test
    public void verifySuccessfullLogin2(){
        homePage.verifyPageTitle("Spree Demo Site");
        homePage.navigateToLoginPage();
        loginPage.verifyPageTitle("Login - Spree Demo Site");
        loginPage.login("shiftqa01@gmail.com", "shiftedtech");
        homePage.verifyLoginSuccess();
    }
}
