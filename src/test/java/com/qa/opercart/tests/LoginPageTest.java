package com.qa.opercart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test
	public void getLoginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();

		System.out.println("LoginPageTitle :" + title);

		// Assert.assertEquals(title, "Account Login"); removed hard-code with constant

		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test

	public void getLoginPageUrlTest() {

		String url = loginPage.getLoginPageUrl();
		// Assert.assertTrue(url.contains("account/login")); removed hard-code with
		// constant

		System.out.println("LoginPageUrl :" + url);

		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));

	}

	@Test

	public void isForgotPasswordLinkExitlTest() {

		boolean link = loginPage.isForgotLinkExit();
		Assert.assertTrue(link);

	}

	@Test(priority=1)

	public void LoginMethodTest() {

		// loginpage.doLoginMethod("amit@gmail.com", "amitjain5991");
		//
		// loginpage.doLoginMethod("amit@gmail.com", "amitjain5991");
		//
		String username = prop.getProperty("username".trim());
		String pwd = prop.getProperty("password").trim();

		loginPage.doLoginMethod(username, pwd);

	}
}

