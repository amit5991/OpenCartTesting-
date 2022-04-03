package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPratice {
	
static	WebDriver driver;
	
	private static By firstname = By.id("input-firstname");
	private static By lastname = By.id("input-lastname");
	private static By email = By.id("input-email");
	private static By telephone = By.id("input-telephone");
	private static By password = By.id("input-password");
	private static By confirmpassword = By.id("input-confirm");
	private static By subscribeYes = By.xpath("(//label[@class='radio-inline'] ) [position()=1]/input");
	private static By subscribeNo = By.xpath("(//label[@class='radio-inline'] ) [position()=2]/input");

	private static By agreeCheckbox = By.name("agree");
	private static By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private static By sucessMessg = By.cssSelector("div#content h1");
	private static By logoutLink = By.linkText("Logout");
	private static By registerLink = By.linkText("Register");

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver =new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		
		sendKeys(firstname,"Maneela");
		sendKeys(lastname,"jain");
		sendKeys(email,"manee@gmail.com");
		sendKeys(telephone,"899999999");
		sendKeys(password,"Maneela@123");
		sendKeys(confirmpassword,"Maneela@123");
		sendKeys(subscribeYes,"yes");
		//sendKeys(firstname,"Maneela");
		
		doclick(agreeCheckbox);
		doclick(continueButton);
		gettext(sucessMessg);
		
		
		
		
		
	}
	
	public static WebElement getWebElement(By locator ) {
		
		return driver.findElement(locator);
		
	}
	
public static void sendKeys(By locator,String value ) {
		
	getWebElement(locator).sendKeys(value);
	
		
	}

public static void doclick (By locator) {
	getWebElement(locator).click();
	
}
public static void gettext (By locator) {
String text= getWebElement(locator).getText();
System.out.println(text);
		}
	

}
