package com.qa.opercart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {

	WebDriver driver;

	DriverFactory df;
	LoginPage loginPage;
	Properties prop;
	AccountPage accPage;
	RegisterPage regPage;
	

	@BeforeTest

	public void SetUp() {

		df = new DriverFactory();

		// this is new method changing hard cod values
		prop = df.init_prop();

		driver = df.initDriver(prop);

		// driver = df.initDriver(chrome);
		loginPage = new LoginPage(driver);

	}

	@AfterTest

	public void tearDown() {

		driver.quit();
	}

}
