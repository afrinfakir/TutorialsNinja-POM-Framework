package com.qa.tninja.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tninja.base.baseTest;
import com.qa.tninja.utils.Constants;

public class AccountspageTest extends baseTest {
	
	@BeforeClass
	public void Accountpagesetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 2)
	public void getAccountspageTitleTest() {
		String title = accountspage.getAccountspageTitle();
		System.out.println("Accounts page title :"+title);
		Assert.assertEquals(title, Constants.Accounts_page_title);
	}
	@Test(priority = 1)
	public void getAccountsHeaderTest() {
		String header = accountspage.getAccountsHeader();
		System.out.println("Accounts header :"+ header);
		Assert.assertEquals(header, Constants.Accounts_header);
	}
	@Test(priority=3)
	public void getcontentListTest() {
		Assert.assertEquals(accountspage.getcontentList(), Constants.getcontentList());
	}
	@Test(priority = 4)
	public void doSearchTest() {
		Assert.assertTrue(accountspage.doSearch("imac"));
	}
	
	

}
