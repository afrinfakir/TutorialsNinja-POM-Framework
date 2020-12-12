package com.qa.tninja.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qa.tninja.pages.Accountspage;
import com.qa.tninja.pages.Loginpage;
import com.qa.tninja.pages.ProductInfopage;
import com.qa.tninja.pages.Registrationpage;
import com.qa.tninja.pages.Shoppingcartpage;

public class baseTest {
	public basepage basepage;
	public Properties prop;
	public WebDriver driver;
	public Loginpage loginpage;
	public Accountspage accountspage;
	public ProductInfopage productInfopage;
	public Registrationpage registerpage;
	public Shoppingcartpage shoppingcartpage;
	
	@Parameters({"browser", "version"})
	@BeforeTest
	public void setup(String browserName, String browserVersion) {
		 basepage = new basepage();
		 prop = basepage.init_prop();
		 String browser = prop.getProperty("browser");
		 if (browserName != null) {
				browser = browserName;
			}
		 driver = basepage.init_driver(browser,browserVersion);
		loginpage = new Loginpage(driver);
		driver.get(prop.getProperty("url")); 
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
