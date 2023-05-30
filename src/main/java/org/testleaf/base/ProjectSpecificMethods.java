package org.testleaf.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testleaf.utils.ReadExcelData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {
	
	private static final ThreadLocal<ChromeDriver> tlDriver=new ThreadLocal<ChromeDriver>();
	//public static ChromeDriver driver;
	public String fileName;

	//Encapsulation since we are using private keyword in Threadlocal
	public void setDriver(ChromeDriver driver ) {
		tlDriver.set(driver);
	}
	
	public ChromeDriver getDriver() {
		return tlDriver.get();
		
	}
	@BeforeMethod
	public void preCondition() throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//driver = new ChromeDriver();
		//tlDriver.set(driver);
		setDriver(new ChromeDriver(options));
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	
	
	  @DataProvider(name="fetchData",parallel=true) public String[][] Data() throws
	  IOException{ return ReadExcelData.readSheetData(fileName); }
	 
}
