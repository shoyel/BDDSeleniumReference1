package com.shiftedtech.qa.junit.functional;

import com.shiftedtech.qa.framework.scriptbase.SpreeScriptBaseJUnit;
import com.shiftedtech.qa.framework.scriptbase.SpreeScriptBaseTestNg;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created by ShiftTeacher on 1/7/2018.
 */
@RunWith(DataProviderRunner.class)
public class SpreeLoginJUnit extends SpreeScriptBaseJUnit {




    @Test()
    @UseDataProvider("loginDataProviderAsExcelWithPOI")
    public void verifySuccessfullLogin(String email, String password){
        homePage.verifyPageTitle("Spree Demo Site");
        homePage.navigateToLoginPage();
        loginPage.verifyPageTitle("Login - Spree Demo Site");
        loginPage.login(email, password);
        homePage.verifyLoginSuccess();
    }

    @DataProvider
    public static Object[][] loginDataProviderAsExcelWithPOI(){
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/SpreeLoginData.xls";

        ExcelReader reader = new ExcelReader(dataFile);
        data = reader.getExcelSheetData("Sheet1",true);
        return data;
    }
}
