package com.shiftedtech.qa.junit.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/*
   mvn clean test -Dcucumber.options="--tags @debug"                   //Only debug
   mvn clean test -Dcucumber.options="--tags @debug --tags @smoke"     //AND
   mvn clean test -Dcucumber.options="--tags @debug,@smoke"            //OR

 */
/**
 * Created by ShiftTeacher on 1/20/2018.
 */
@RunWith(Cucumber.class)
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
public class BDDRunnerJUnit {
}
