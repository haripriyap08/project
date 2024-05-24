package com.travel_Insurance.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.Parameters;

import com.insurance.utils.helperClass;
//import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	static WebDriver driver;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

    //Method executed after each step in a scenario
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if(!scenario.isFailed()) {
        	driver=helperClass.getDriver();
        	TakesScreenshot ts=(TakesScreenshot) driver;				// Taking a screenshot using the WebDriver
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);		// Getting the screenshot as bytes
        	scenario.attach(screenshot, "image/png",scenario.getName());		// Attaching the screenshot to the scenario
        	            
        }
    }


}
