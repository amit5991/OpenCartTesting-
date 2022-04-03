package com.qa.opencart.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterPage {

	private WebDriver driver;

	private ElementUtils eleUtil;

	private By regpageheaader = By.cssSelector("div#content h1");

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'] ) [position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'] ) [position()=2]/input");

	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

		eleUtil = new ElementUtils(driver);

	}

	public String getRegisterPageTitle() {
		// driver.getTitle();
		return eleUtil.doGetPageTitleIs(Constants.REGISTER_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getRegisterPageUrl() {
		// driver.getCurrentUrl();
		return eleUtil.waitForUrlContains(Constants.REGISTER_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}

	public String getRegisterPageHeaderTitle() {

		return eleUtil.doGetText1(regpageheaader);

	}

	public boolean userRegistration(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {

		eleUtil.doSendKeys(this.firstname, firstname);
		eleUtil.doSendKeys(this.lastname, lastname);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {

			eleUtil.doClick(subscribeYes);
		}

		else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckbox);
		eleUtil.doClick(continueButton);
		
		String successMesg = eleUtil.doGetText1(sucessMessg);
		System.out.println(successMesg);

		if (successMesg.contains(Constants.REGISTER_SUCCESS_MESSG))
		{
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		return false;
		

	}

}
