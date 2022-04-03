package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class AccountPage {
	private WebDriver driver;
	private ElementUtils eleutil;

	private By header = By.cssSelector("div#logo a");

	private By sectionheader = By.cssSelector("div.col-sm-9 h2");

	private By logout = By.linkText("Logout");
	private By search = By.name("search");

	private By searchIcon = By.cssSelector("div#search button");

	public AccountPage(WebDriver driver) {

		this.driver = driver;

		
		eleutil = new ElementUtils(driver);
	}

	public String getAccountPageTitle() {
		return eleutil.doGetPageTitleIs(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getAccountPageUrl() {

		return eleutil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);

	}

	public String getAccPageHeaderTitle() {

		return eleutil.doGetText1(header);
	}

	public List<String> getSectionHeader() {

		List<WebElement> sectionList = eleutil.waitForElementsVisible(sectionheader, 10);

		List<String> secValList = new ArrayList<String>();

		for (WebElement e : sectionList) {

			String val = e.getText();

			secValList.add(val);
		}
		return secValList;

	}

	public boolean isLogoutLinkExit() {

		return eleutil.doIsDisplayed(logout);

	}

	public boolean logout() {
		if (isLogoutLinkExit()) {

			eleutil.doClick(logout);

			return true;
		}
		return false;
	}

	public boolean SearchExit() {

		return eleutil.doIsDisplayed(search);

	}

	public ResultsPage doSearch(String productname) {
		if (SearchExit()) {

			eleutil.doSendKeys(search, productname);
			eleutil.doClick(searchIcon);
			
			return new ResultsPage(driver);

		}
		return null;

	}
	
}

