package com.travel_Insurance.testRunner;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.insurance.utils.helperClass;

//import org.junit.runner.RunWith;
//import org.testng.annotations.Test;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/featureFile/policyBazaarE2E.feature"},															// Specifying the location of the feature file(s) that contain Gherkin syntax
				 glue= {"com.travel_Insurance.stepDefinitions"} ,																				// Specifying the package containing step definitions
				 plugin={"pretty","html:Cucumberreport/myreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},  // Plugins for generating different types of reports
				dryRun=false,
				monochrome=true,
				publish=true
		)

//The class extending AbstractTestNGCucumberTests to run Cucumber with TestNG
public class testRun extends AbstractTestNGCucumberTests{

	static WebDriver driver;
	static String browser;
	static Properties props;
	
	@BeforeMethod
	@Parameters({"browser"})
	public static void setup(String b) throws IOException {				//BeforeAll is used for initializing driver only once
		driver=helperClass.getWebDriver(b);			//initializing webDriver to driver
		props = helperClass.getProperties();		//getting properties file from helper class
		driver.manage().window().maximize();			//maximizing the window
		driver.get(props.getProperty("appURL"));		//getting Be cognizant url from config properties file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
		{
			driver.quit();
		}
	}
	}

