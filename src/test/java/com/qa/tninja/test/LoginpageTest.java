package com.qa.tninja.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tninja.base.baseTest;
import com.qa.tninja.utils.Constants;

public class LoginpageTest extends baseTest {
	
	
	@Test(priority=1)
	public void getTitleLoginPageTest() {
		String Title = loginpage.getTitleLoginPage();
		System.out.println("the title of page : "+ Title);
		Assert.assertEquals(Title, Constants.Login_page_title);
	}
	
	@Test(priority=2)
	public void isforgotpwdlinkExistTest() {
		Assert.assertTrue(loginpage.isforgotpwdlinkExist());
	}
	
	
	@Test(priority=3)
	public void dologinTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
