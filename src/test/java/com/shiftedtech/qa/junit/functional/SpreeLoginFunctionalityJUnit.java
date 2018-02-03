package com.shiftedtech.qa.junit.functional;

import com.shiftedtech.qa.framework.scriptbase.SpreeScriptBaseJUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
@RunWith(Parameterized.class)
public class SpreeLoginFunctionalityJUnit extends SpreeScriptBaseJUnit{

    @Test
    public void verifySuccessfullLogin(){
        homePage.verifyPageTitle("Spree Demo Site");
        homePage.navigateToLoginPage();
        loginPage.verifyPageTitle("Login - Spree Demo Site");
        loginPage.login("shiftqa01@gmail.com", "shiftedtech");
        homePage.verifyLoginSuccess();
    }
}
