package com.qa.tninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.tninja.base.basepage;
import com.qa.tninja.utils.Constants;
import com.qa.tninja.utils.ElementUtils;

public class Loginpage extends basepage {

	private WebDriver driver;
	private ElementUtils elementUtil;

	//By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
	private By forgotpwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	//constructor of class
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(this.driver);
	}

	//page actions or methods
	public String getTitleLoginPage() {
		return elementUtil.waitForTitlePresent(Constants.Login_page_title, 10);
	}

	public boolean isforgotpwdlinkExist() {
		return elementUtil.doIsDisplayed(forgotpwdLink);
	}

	public Accountspage doLogin(String un, String pw) {
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(password, pw);
		elementUtil.doClick(loginButton);
		return new Accountspage(driver);
	}

	public Registrationpage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new Registrationpage(driver);
	}

}
