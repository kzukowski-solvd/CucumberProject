package com.solvd.carina.demo.cucumber.test;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/OrderPlacement.feature",
        glue = "com.solvd.carina.demo.cucumber.steps"
)
public class CucumberTestRunner extends CucumberBaseTest {
}
