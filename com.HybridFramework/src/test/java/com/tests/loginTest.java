package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class loginTest extends BaseClass {
	LoginPage lp;
@BeforeSuite
public void setUp() {
driver=initilization();	
reportInit();
lp=new LoginPage(driver);
	
}
@Test
public void logInTitle() {
	log.info("executing a test for loginTitle");
	Assert.assertEquals(driver.getTitle(),"JavaByKiran | Log in");
	
}
@Test
public void logInLogo() {
	log.info("executing a test for logiInLogo");
/*	WebElement Logo =driver.findElement(By.tagName("img"));
	Assert.assertFalse(Logo.isDisplayed());*/
	Assert.assertTrue(lp.verifyLogo());
}
/*@Test
public void logInLable() {
	log.info("executing a test for loginlable");
	WebElement text=driver.findElement(By.tagName("b"));
	throw new SkipException("skipping a test");
			
}*/
@Test
public void logInLable() {
	log.info("executing a test for loginlable");
	Assert.assertEquals(lp.verifyLable(), "Java By Kiran");

}
}