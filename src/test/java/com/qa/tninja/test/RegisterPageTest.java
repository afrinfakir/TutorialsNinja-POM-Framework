package com.qa.tninja.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tninja.base.baseTest;
import com.qa.tninja.utils.Constants;
import com.qa.tninja.utils.ExcelUtils;

public class RegisterPageTest extends baseTest {

	@BeforeClass
	public void registerPageSetUp() {
		registerpage = loginpage.navigateToRegisterPage();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtils.getTestData("registration");
		return data;
	}

	@Test(dataProvider = "getRegisterData")
	
	public void userRegisterationTest(String firstname, String lastname, String email, String telephone,
			String password, String subscribe) {
	//@Test
		//public void userRegisterationTest(){
		registerpage.accountRegistration(firstname, lastname, email, telephone, password, subscribe);
		//registerpage.accountRegistration("adh", "kjk", "as@gmail.com", "98565889", "46877887", "yes");
	}

	}


