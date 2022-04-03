package com.qa.opercart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class RegisterPageTest extends BaseTest {

	@BeforeClass

	public void regPageSetUp() {
		regPage = loginPage.goToRegisterPage();

	}

	public String getrandomnumber() {
		Random randomgen = new Random();
		String email = "nestec"+randomgen.nextInt(20) + "gmail.com";

		return email;

	}

	@Test

	public void getRegisterPageTitleTest() {
		String acttitle = regPage.getRegisterPageTitle();

		System.out.println("Register page title :" + acttitle);
		Assert.assertEquals(acttitle, Constants.REGISTER_PAGE_TITLE);

	}

	@Test
	public void getRegisterPageUrlTest() {
		String acturl = regPage.getRegisterPageUrl();

		System.out.println("Register page url :" + acturl);

		Assert.assertTrue(acturl.contains(Constants.REGISTER_PAGE_URL_FRACTION));
	}

	@Test
	public void getRegPageHeaderTitleTest() {

		String regheader = regPage.getRegisterPageHeaderTitle();

		System.out.println("Register page header :" + regheader);
		Assert.assertEquals(regheader, Constants.REGISTER_PAGE_HEADER_TITLE);

	}

	@DataProvider

	public Object[][] getRegistrationTestData() {

		return new Object[][]

		{ { "M", "jain", "8209362359", " Maneela@123", "NO" },
				{ "R", "jain", "8309362359", " Maneela@123", "NO" },
				{ "sm", "jain", "8409362359", " Maneela@123", "yes" },
				{ "T", "jain", "8409362359", " Maneela@123", "NO" },
				{ "Ri", "jain", "8609362359", " Maneela@123", "NO" }

		};
	}

	@Test(dataProvider = "getRegistrationTestData")

	public void userRegistrationTest(String name, String lastname,String telephone, String password, String subscribe)

	{
	Assert.assertTrue(regPage.userRegistration(name, lastname, getrandomnumber() , telephone, password, subscribe));

	}

}
