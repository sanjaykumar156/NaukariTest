package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseClass.BasePage;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='nI-gNb-drawer__icon']")
	WebElement logoutbtn;
	@FindBy(xpath="//a[@title='Logout']")
	WebElement logout;
	
	public void navigatebutton() {
		logoutbtn.click();
	}
	public void logoutbutton() {
		logout.click();
	}
}
