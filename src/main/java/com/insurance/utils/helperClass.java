package com.insurance.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class helperClass {
	static WebDriver driver; 											// declaring the Webdriver to driver variable
	static Scanner sc = new Scanner(System.in); 						// taking input from the user
	static Properties props; 											// declaring the properties to props variable
	static FileReader reader; 										   	// declaring the FileReader to reader variable
					
 
	public static WebDriver getWebDriver(String browser) throws IOException {
 
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) 
		{																						//getting environment from config properties file
			DesiredCapabilities capabilities = new DesiredCapabilities();			
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) 					//getting windows OS from config properties file
			{
				capabilities.setPlatform(Platform.WIN11);
			} 
			else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) 
			{																					//getting Mac OS from config properties file
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No matching OS..");
			}
			// browser
			switch (browser.toLowerCase()) {	
			case "chrome":
				capabilities.setBrowserName("chrome");					//getting chrome browser from config properties file
				break;
			case "edge":
				capabilities.setBrowserName("edge");					//getting edge browser from config properties file
				break;
			default:
				System.out.println("No matching browser");
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} 
		else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) 
		{
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();						//driver deletes the cookies 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;
	}
 
	public static WebDriver getDriver() {
		return driver; 				// return driver instance
	}
 
	public static Properties getProperties() {
		try {
			reader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");					//reading config properties file 
			props = new Properties(); 			// setting properties to props variable
			props.load(reader); 				// loading the properties file
		} 
		catch (Exception e) { 					// catch exception if properties file not found
 
		}
		return props; 							// return properties
	}
	
	public static void Screenshot(String name) throws Exception
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;		// Taking a screenshot using the WebDriver
		File source = ts.getScreenshotAs(OutputType.FILE);
	    String dest = System.getProperty("user.dir") +"/Screenshots/"+name+".png"; 		// Setting destination path for the screenshot
	    File destination = new File(dest);
	    FileUtils.copyFile(source, destination); 
    }
	
}
