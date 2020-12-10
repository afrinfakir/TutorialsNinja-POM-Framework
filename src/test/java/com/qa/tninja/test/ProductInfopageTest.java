package com.qa.tninja.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tninja.base.baseTest;

public class ProductInfopageTest extends baseTest {

	@BeforeClass
	public void productInfoSetUp() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	// @Test
	// public void ProductInforPageTitleTest_iMac() {
	// accountspage.doSearch("iMac");
	// productInfopage = accountspage.clickOnSpecProd("iMac");
	// //String title= productInfopage.getProductInfoPageTitle("imac");
	// //System.out.println("The title--------imac page title:"+title);
	// Assert.assertEquals(productInfopage.getProductInfoPageTitle("imac"), "imac");
	//
	// }

	@Test(priority = 1)
	public void verifyProductInfoTest_MacBook() {
		// String productName = "Macbook";
		accountspage.doSearch("MacBook");
		productInfopage = accountspage.clickOnSpecProd("MacBook Pro");
		Assert.assertTrue(productInfopage.getProductImages() == 4);
		Map<String, String> produtcInfoMap = productInfopage.getProductInformation();
		System.out.println(produtcInfoMap);
		// {Brand=Apple, Availability=In Stock,
		// price=$2,000.00, name=MacBook Pro,
		// Product Code=Product 18, Reward Points=800,
		// exTaxPrice=$2,000.00}

		Assert.assertEquals(produtcInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(produtcInfoMap.get("Reward Points"), "800");
		productInfopage.selectQuantity("3");
		productInfopage.addToCart();

	}
	// @Test
	// public void addTocartTest_macbook() {
	// boolean b = productInfopage.addToCart();
	// Assert.assertTrue(b);
	// }

	@Test(priority = 2)
	public void verifyProductInfoTest_iMac() {
		// String productName = "iMac";
		accountspage.doSearch("imac");
		productInfopage = accountspage.clickOnSpecProd("iMac");
		Assert.assertTrue(productInfopage.getProductImages() == 3);

		Map<String, String> produtcInfoMap = productInfopage.getProductInformation();
		System.out.println(produtcInfoMap);

		// {Brand=Apple, Availability=In Stock,
		// price=$100.00, name=iMac,
		// Product Code=Product 14,
		// exTaxPrice=$100.00}

		Assert.assertEquals(produtcInfoMap.get("name"), "iMac");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("price"), "$100.00");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 14");
		productInfopage.selectQuantity("1");
		productInfopage.addToCart();

	}

	@Test(priority = 3)
	public void verifyProductInfoTest_samsung() {
		// String productName = "samsung";
		accountspage.doSearch("samsung");
		productInfopage = accountspage.clickOnSpecProd("Samsung Galaxy Tab 10.1");
		Assert.assertTrue(productInfopage.getProductImages() == 7);

		// {Availability=Pre-Order, price=$199.99,
		// name=Samsung Galaxy Tab 10.1, Product Code=SAM1,
		// Reward Points=1000, exTaxPrice=$199.99}

		Map<String, String> produtcInfoMap = productInfopage.getProductInformation();
		System.out.println(produtcInfoMap);
		Assert.assertEquals(produtcInfoMap.get("name"), "Samsung Galaxy Tab 10.1");
		Assert.assertEquals(produtcInfoMap.get("price"), "$199.99");
		Assert.assertEquals(produtcInfoMap.get("Availability"), "Pre-Order");
		Assert.assertEquals(produtcInfoMap.get("Reward Points"), "1000");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "SAM1");
		productInfopage.selectQuantity("2");
		productInfopage.addToCart();
	}

	@Test(priority = 4)
	public void clickonCartTest() {
		Assert.assertTrue(productInfopage.clickOnCart());
	}

	@Test(priority = 5)
	public void clickonViewCartTest() {
		
		productInfopage.clickonViewCart();
	}

}
