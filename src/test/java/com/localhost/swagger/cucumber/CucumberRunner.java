package com.localhost.swagger.cucumber;


import com.localhost.swagger.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Jay
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/",
tags="@SMOKE")
public class CucumberRunner extends TestBase {


}
