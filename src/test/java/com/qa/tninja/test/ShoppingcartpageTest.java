package com.qa.tninja.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tninja.base.baseTest;
import com.qa.tninja.utils.Constants;

public class ShoppingcartpageTest  extends baseTest{
	
	
	@BeforeClass
	public void shoppingcartSetUp() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority= 7)
	public void ClickoncheckoutTest() {
		Assert.assertTrue(shoppingcartpage.Clickoncheckout());
	}
	@Test(priority = 6)
	public void totalPriceTest() {
		shoppingcartpage.totalPrice();
	}
	
	@Test(priority = 5)
	public void UseGiftCodeTest() {
		String GiftCode = "GIFT2020";
		Assert.assertTrue(shoppingcartpage.UseGiftCode(GiftCode));
	}
	@Test(priority = 4)
	public void selectShippingDestinationTest() {
		Assert.assertTrue(shoppingcartpage.selectShippingDestination("Turkey", "Ağrı", "3456778"));
	}
	@Test(priority = 3)
	public void UseCouponCodeTest() {
		String coupon = "AGHbsd10";
		Assert.assertTrue(shoppingcartpage.UseCouponCode(coupon));
	}
	@Test(priority = 1)
	public void getTitle_shoppingpageTest() {
		accountspage.doSearch("iMac");
		productInfopage = accountspage.clickOnSpecProd("iMac");	
		productInfopage.clickOnCart();
		shoppingcartpage=productInfopage.clickonViewCart();
		String title = shoppingcartpage.getTitleshoppingpage();
		System.out.println("Shopping cart page title :"+title);
		Assert.assertEquals(title, Constants.shoppingcart_page_title);
	}
	@Test(priority = 2)
	public void getproductInfoTest() {
		shoppingcartpage.getproductInfo_MacBookPro();
	}
}
