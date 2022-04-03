package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	// nw ceating properties ref to create new method and remove hard code
	
	  public Properties prop;

	/**
	 * This method is to initialize the driver
	 * @param browser 
	 * 
	 * @param browserName
	 * @return the WebDriver driver
	 */

	//public WebDriver initDriver(String browserName) 
	  public WebDriver initDriver  (Properties prop) {
		  
		 String browserName= prop.getProperty("browser").trim();

		System.out.println("BrowserName is :" + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}

		else {

			System.out.println("Please pass the correct browserName :" + browserName);

		}

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		String url =prop.getProperty("url");
		driver.get(url);

		return driver;
	}
	/**
	 * This method is used to initialize the properties
	 * @return its return Properties class reference
	 */
	public Properties init_prop() {
		prop =new Properties();
		
	try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
		
		
	}
	return prop;
			
	}

}
