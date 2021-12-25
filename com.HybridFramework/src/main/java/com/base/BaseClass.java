package com.base;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.ScreenshotException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtils;

public class BaseClass {
	
public static WebDriver driver;
public static ExtentReports report;
public static ExtentSparkReporter spark;
public static ExtentTest test;
public static Logger log=Logger.getLogger(BaseClass.class);

public WebDriver initilization() {
	log.info("reading a property file for browser");
	if(PropertiesUtils.readProperty("browser").equals("chrome")) {
		log.info("browser name is chrome");
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver();
	log.info("chrome browser is opened");
}
	if(PropertiesUtils.readProperty("browser").equals("firefox")) {
		log.info("browser name is firefox");
	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
	driver=new FirefoxDriver();
	log.info("firefox browser is opened");
}
	driver.get(PropertiesUtils.readProperty("url"));
	driver.manage().window().maximize();
	log.info("maximizing browser window");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	log.info("applying implicitly and pageload waits");
	return driver;

}
public void reportInit() {
	report=new ExtentReports();
	log.info("initilizing extent report");
	spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
	log.info("extent report to be saved in target folder");
	report.attachReporter(spark);
	
}
public String getScreenshot( String name) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/screenshot/"+name+".jpg";
	File dest=new File(path);
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return path;
}
}


















