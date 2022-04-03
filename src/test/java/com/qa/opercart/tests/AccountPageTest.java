package com.qa.opercart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass

	public void accountPageSetUp() {
	String pwd =prop.getProperty("password".trim());

		accPage =loginPage.doLoginMethod(prop.getProperty("username".trim()), pwd);

	}
	

	@Test

	public void getAccountPageTitleTest() {
		String acttitle = accPage.getAccountPageTitle();

		System.out.println("Account page title :" + acttitle);
		Assert.assertEquals(acttitle, Constants.ACCOUNT_PAGE_TITLE);

	}

	@Test
	public void getAccountPageUrlTest() {
		String acturl = accPage.getAccountPageUrl();

		System.out.println("Account page url :" + acturl);

		Assert.assertTrue(acturl.contains(Constants.ACCOUNT_PAGE_URL_FRACTION));
	}

	@Test
	public void getAccPageHeaderTitleTest() {
		
	String actheader =accPage.getAccPageHeaderTitle();
	
	
	System.out.println("Account page header :" + actheader);
	Assert.assertEquals(actheader, Constants.ACCOUNT_PAGE_HEADER_TITLE);
	
	}
	
	@Test
	public void getSectionHeaderTest(){
		
	List<String> actsecheader =	accPage.getSectionHeader();
	System.out.println("Account Section header :" + actsecheader);
	
	Assert.assertEquals(actsecheader,Constants.ACCOUNT_SECTION_HEADER_TITLE);
		
	}
	

	

}
