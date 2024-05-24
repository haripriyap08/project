package com.travel_Insurance.pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class carInsurancePage extends basePage{

	public carInsurancePage(WebDriver driver) 
	{
		super(driver);
	}
	
	By carInsBtn=By.xpath("(//div[@class='prd-icon add shadowHandler short'])[4]");    		
	By viewPriceBtncarno=By.xpath("//button[@id=\"btnGetQuotes\"]");			
	By viewprices2btn=By.xpath("//div[@class=\"CarRegDetails_carRegForm__Iqhdb\"]/button");
	By carNoErrMsg=By.id("error_car_number");	
	By carNoTxtBox=By.id("regNoTextBox");													
	
	By carBrandnames=By.xpath("//ul[@class=\"slideInRight animated5 manufact-listcb\"]//li/span"); 
	By carModelnames=By.xpath("//ul[@class='slideInRight slideInRightanimated model-list']//li/span"); 
	By carfuelType=By.xpath("//div[@id='dvFuelType']/ul//li//span");								
	By carvarients=By.xpath("//div[@id='variantScroll']/li//span");									
	By caryearreg=By.xpath("//*[@id='dvRegYear']/ul/div/li");										
	By carmodels=By.xpath("//ul[1]/div[@id=\"modelScroll\"]/li");									
	By varientsofcar=By.xpath("//ul[1]/div[@id=\"variantScroll\"]/li");
	
	By fullname=By.xpath("//input[@id=\"name\"]");
	By nameErrmsg=By.xpath("//*[@id='dvVariant']/div[2]/div[1]/div[1]/div[1]");
	By emailaddr=By.xpath("//input[@id=\"email\"]");
	By emailErrmessage=By.xpath("//div[@class=\" customer-detail\"]/div[2]/div[@class=\"msg-error show\"]");
	By phnNoBox=By.xpath("//input[@id=\"mobileNo\"]");
	By errMsgmob=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[1]");
	By viewPriceBtn1=By.xpath("//button[@id='btnLeadDetails']");
	By plcbzIcon=By.xpath("//a[@class=\"pb-logo\"]");
	
	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	//clicking on car insurance button in home page
	public void carInsButton() throws Exception
	{
		driver.findElement(carInsBtn).click();														//clicking car insurance button in homepage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	Thread.sleep(2000);		
	}
	
	//getting page title
	public String pageTitle() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		return(driver.getTitle());												// Returns the title of the page
	}
	
	//clicking in view price button
	public void viewPriceButton()
	{
		try
		{
		driver.findElement(viewPriceBtncarno).click(); 	//view prices button in car insurance page
		}
		catch(Exception e)
		{
			driver.findElement(viewprices2btn).click();
		}
		
	
	}
	
	//printing car number error
	public String invalidCarNoErr()
	{
		try
		{
			String errormsg=driver.findElement(carNoErrMsg).getText();				//getting error message for car number 
			System.out.println(errormsg);
			return errormsg;
		}
		catch(Exception e)
		{
			String errormsg=driver.findElement(By.xpath("//div[@class='CarRegDetails_inputField__CBXxE']/p")).getText();
			System.out.println(errormsg);
			return errormsg;
		}
		
	}
	
	//enetering carno in textbox
	public void carNoTxtBx(String carnumber)
	{
		driver.findElement(By.id("regNoTextBox")).sendKeys(carnumber);         //entering car number into car number textbox
		
	}
	

	//selecting car brand  name
	public void carBrand(String brandname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try 
		{
			
			driver.findElement(By.xpath("//ul[@class='slideInRight animated5 manufact-listcb']//li[9]")).click();
	
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//ul[@class=\"gridList slideToLeft\"]/li[9]")).click();	
		}
		
		
	}
	
	//selecting car model name
	public void carModel(String modelname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try
		{
			driver.findElement(By.xpath("//*[@id=\"modelScroll\"]/li[5]/span")).click();  //clicking on car model in car insurance page
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//ul[@class=\"gridList    slideToLeft mb-16\"]//li[5]")).click();
		}

	}
	
	//selecting car fuel type name
	public void carFuelType(String fuelType)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.findElement(By.xpath("//div[@id='dvFuelType']/ul//li[2]//span")).click();
	
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//ul[@class='gridList slideToLeft']//li[2]")).click();
		}
	}
	
	//selecting car variant page in car insurance page
	public void carVariantType(String varienttype)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try
		{
		driver.findElement(By.xpath("//*[@id=\"variantScroll\"]/li[2]/span")).click();	//clicking on car variant types in car insurance page
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//ul[@class='gridList slideToLeft mb-24']/li[1]")).click();
		}
	}
	
	//selecting car registered year
	public void carRegyear(String year)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try 
		{
			driver.findElement(By.xpath("//*[@id='dvRegYear']/ul/div/li[1]")).click();

		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//ul[@class=\"gridList    slideToLeft\"]/li[2]")).click();
		}
	}
	
	//entering name in name text box in car insurance page
	public void fullNamereg(String name)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try 
		{
		WebElement namebox=driver.findElement(fullname);					//name textbox 
		namebox.sendKeys(name);												//enters name in the textbox
		namebox.sendKeys(Keys.BACK_SPACE);
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys(name);
		}
		
	}

	//name error message in car insurance contact page
	public String nameError()
	{
		try
		{
			WebElement nameerr=driver.findElement(nameErrmsg);					
			return (nameerr.getText()); 
		}
		catch(Exception e)
		{
			WebElement nameerr=driver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]"));					
			return (nameerr.getText());
		}
	}
	
	//sending email address to email text box in car insurance contact page
	public void email(String mail)
	{
		try
		{
		WebElement emailbox=driver.findElement(emailaddr);
		emailbox.sendKeys(mail);
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys(mail);
		}
	}
	
	// getting email error message in car insurance contact page
	public String emailerrMsg() throws Exception
	{
		Thread.sleep(1000);
		try {
			WebElement emailerr=driver.findElement(emailErrmessage);
			return (emailerr.getText()); 
		}
		catch(Exception e)
		{
			WebElement emailerr=driver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]"));
			return (emailerr.getText());
		}
	}
	
	//entering mobile number in mobile text box
	public void mobileNo(String phnNo)
	{
		try
		{
		WebElement mobilenobox=driver.findElement(By.xpath("//input[@id=\"mobileNo\"]"));
		mobilenobox.sendKeys(phnNo);
		mobilenobox.sendKeys(Keys.BACK_SPACE);
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//input[@class=\"form-control\"])[3]")).sendKeys(phnNo);
		}
		
	}
	
	//getting mobile number error in car insurance contact page 
	public String errMobNo()
	{
		try
		{
			WebElement mobileerr=driver.findElement(errMsgmob);
			return (mobileerr.getText());
		}
		catch(Exception e)
		{
			WebElement mobileerr=driver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/div[2]/div/div/div/div[3]/div/div[2]"));
			return (mobileerr.getText());
		}
	}
	
	//clicking on view price button in contact page
	public void viewprices()
	{
		try
		{
			driver.findElement(viewPriceBtn1).click();
		}
		catch(Exception e)
		{
		
		}

	}
	
	//clicking on policy bazaar icon
	public void backhome()
	{
		try
		{
			driver.findElement(plcbzIcon).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//div[@class='logo']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
	}
}
