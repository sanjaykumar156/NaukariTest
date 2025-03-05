package com.Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.LogoutPage;
import com.baseClass.BaseTest;
import com.baseClass.ConfigReader;

public class LoginTest extends BaseTest{

	@Test
	public void logintest() throws IOException, InterruptedException {
		
		LoginPage login= new LoginPage(getDriver());
		login.loginbutton();
		login.usernamepasswordfiels(ConfigReader.getproperty("username"),ConfigReader.getproperty("password"));
		login.signinbutton();
		Assert.assertEquals(login.homepagevalidation(), true);
		login.myprofilebutton();
		WebElement element= login.editbutton();
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,500);");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		login.locationupdate();
		login.locationselect();
		login.svaebutton();
		Assert.assertEquals(login.verifysuccesstext(), true);
		
		LogoutPage logout=new LogoutPage(getDriver());
		logout.navigatebutton();
		logout.logoutbutton();
	}

}
