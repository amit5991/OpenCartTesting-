package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtils eleutil;
	
	private By searchHeader = By.cssSelector("div#content h1");
	
	private By productResult= By.cssSelector("div.caption a");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtils(driver);

	}
	
	public void getProductListCount() {
		
	}

}
