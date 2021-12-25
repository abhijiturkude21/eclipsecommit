package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepository {
	@FindBy(id="email")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//button")
	public	WebElement loginBtn;
	
	@FindBy(tagName="img")
	public WebElement logo;
	
	@FindBy(tagName="b")
	public WebElement lable;
}
