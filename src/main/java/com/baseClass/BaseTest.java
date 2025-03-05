package com.baseClass;


import java.io.IOException;
import java.net.URL;

import java.time.Duration;




import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseTest {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		if(ConfigReader.getproperty("execution_environment").equals("remote")){
			//platform set
			switch(os.toLowerCase()) {
			case "windows":
			capabilities.setPlatform(Platform.WIN10);
			break;
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
			default:
				throw new IllegalArgumentException("Unsupported OS: " + os);
			}
		//browser setup	
			switch(browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("Chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("FireFox");
				break;
			default:
				throw new IllegalArgumentException("Unsupported Browser: " + browser);
			}
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
		}
		//local
		else if(ConfigReader.getproperty("execution_environment").equals("local")) {
			if(driver.get()==null) {
			switch(browser.toLowerCase()) {
			case "chrome":
				ChromeOptions options=new ChromeOptions();
				//options.addArguments("--headless");
				driver.set(new ChromeDriver(options));
				break;
			case "edge":
				EdgeOptions option=new EdgeOptions();
				//option.addArguments("--headless");
				driver.set(new EdgeDriver(option));
				break;
			case "firefox":
				driver.set(new FirefoxDriver());
				break;
			default:
				throw new IllegalArgumentException("Unsupported Browser: " + browser);
			}
			}
		}
		WebDriver currentdriver = getDriver();
		if(driver.get()!=null) {
			currentdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			currentdriver.manage().window().maximize();
			currentdriver.get(ConfigReader.getproperty("url"));
		}
		}
	@AfterClass
	public void teardown() {

		if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
	}
    public static WebDriver getDriver() {
        return driver.get();
    }
	}


