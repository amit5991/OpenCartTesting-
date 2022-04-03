package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	

	private WebDriver driver;

	private ElementUtils eleUtil;

	// 1. Private By locators

	private By emailID = By.id("input-email");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By fortgotPwd = By.linkText("Forgotten Password");
	private By password = By.id("input-password");

	private By registerlink = By.linkText("Register");
	

	// 2.Constructor

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		eleUtil = new ElementUtils(driver); // this utilities are used to remove cardcode value to perform action

	}

	// 3 public page Action /methods

	public String getLoginPageTitle() {
		// driver.getTitle();
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getLoginPageUrl() {
		// driver.getCurrentUrl();
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}

	public boolean isForgotLinkExit() {
		// driver.findElement(fortgotPwd).//isDisplayed()
		return eleUtil.doIsDisplayed(fortgotPwd);
	}

	public AccountPage doLoginMethod(String username, String pwd) {

//		driver.findElement(emailID).sendKeys(username);
//
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();

		eleUtil.doSendKeys(emailID, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return new AccountPage(driver);
		
		

	}

	// For landing page of register need to create new object of register page
	public RegisterPage goToRegisterPage() {

	eleUtil.doClick(registerlink);

		return new RegisterPage(driver);

	}
}
