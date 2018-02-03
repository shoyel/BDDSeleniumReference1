package com.shiftedtech.qa.testng.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */

@CucumberOptions(
        //tags = { "@debug" },
        //tags = { "@smoke" },         /* smoke test only */
        tags = { "@smoke,@debug" }, /* debug or smoke test */
        //tags = { "@smoke","@debug" },  /* debug and smoke test */
        //monochrome = true,
        features = "src/test/resources/features/",
        //features = "src/test/resources/features/LoginFunctionality2.feature",
        //features = {"src/test/resources/features/LoginFunctionality2.feature",
        //            "src/test/resources/features/LoginFunctionality.feature"},
        glue = {"com.shiftedtech.qa.framework.steps.hook",
                "com.shiftedtech.qa.framework.steps"},
        //dryRun = true,
        plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml"
        }
)
public class BDDRunnerTestNG {
    private TestNGCucumberRunner cucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        cucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber" ,dataProvider = "features", description = "Runs cucumber features")
    public void fature(CucumberFeatureWrapper cucumberFeature){
        cucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features(){
        return cucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        cucumberRunner.finish();
    }
}
