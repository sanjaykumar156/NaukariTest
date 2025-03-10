package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseClass.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@id='login_Layer']")//username
	WebElement loginbtn;
	@FindBy(xpath="//input[starts-with(@placeholder, 'Enter your active')]")
	WebElement usernametxt;
	@FindBy(xpath="//input[@placeholder='Enter your password']")//password
	WebElement passwordtxt;
	@FindBy(xpath="//button[text()='Login']")//button
	WebElement signbtn;
	@FindBy(xpath="//div[@title='Sanjay Kumar ']")//return text
	WebElement textvalidation;
	@FindBy(xpath="//div[normalize-space()='View profile']")//button
	WebElement myprofilebtn;
	@FindBy(xpath="//div[@class='row emp-list']//span[text()='editOneTheme']")//button
	WebElement editbtn;
	@FindBy(xpath="//input[@id='locationSugg']")//text
	WebElement locationadd;
	@FindBy(xpath="//div[@id='sugDrp_locationSugg']")//dropdown
	List<WebElement> locationselect;
	@FindBy(id="submitEmployment")//button
	WebElement saveslocationsbtn;
	@FindBy(xpath="//p[@class='msg']")//return text
	WebElement successtxt;
	
	String username = System.getenv("NAUKRI_USERNAME");
    String password = System.getenv("NAUKRI_PASSWORD");
    
	public void loginbutton() {
		loginbtn.click();
	}
	public void usernamefield() {
		usernametxt.sendKeys(username);
	}
	public void passwordfield() {
		passwordtxt.sendKeys(password);
	}
	public void signinbutton() {
		signbtn.click();
	}
	public boolean homepagevalidation() {
		boolean homepagevalidation=textvalidation.isDisplayed();
		return homepagevalidation;
	}
	public void myprofilebutton() {
	myprofilebtn.click();
	}
	public WebElement editbutton() {
		return editbtn;
	}
	public void locationupdate() {
		locationadd.clear();
		//locationadd.sendKeys("Beng");
	}
	public void locationselect() {
		int size=locationselect.size();
		for(int i=0;i<size;i++) {
			if(locationselect.get(i).getText().equals("Bengaluru")) {
				locationselect.get(i).click();
			}
		}
	}
	public void svaebutton() {
		saveslocationsbtn.click();
	}
	public boolean verifysuccesstext() {
		return successtxt.isDisplayed();
	}
	
}
