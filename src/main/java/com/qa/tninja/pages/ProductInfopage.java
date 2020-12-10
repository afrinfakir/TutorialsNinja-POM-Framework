package com.qa.tninja.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.tninja.base.basepage;
import com.qa.tninja.utils.ElementUtils;

public class ProductInfopage extends basepage{
	
	private WebDriver driver;
	private ElementUtils elementUtil;
	
	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li img");
	//private By successmsg = By.xpath("//div[@class='alert alert-success alert-dismissible']/a");
	private By cart = By.cssSelector("#cart button #cart-total");
	private By viewCart = By.xpath("//strong/i[@class='fa fa-shopping-cart']");

	public ProductInfopage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(this.driver);
	}

	public Map<String, String> getProductInformation() {

		Map<String, String> productInfoMap = new HashMap<>();
		productInfoMap.put("name", elementUtil.getElement(productNameHeader).getText().trim());

		List<WebElement> productMetaDataList = elementUtil.getElements(productMetaData);
		for (WebElement e : productMetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}

		List<WebElement> productPriceList = elementUtil.getElements(productPrice);
		productInfoMap.put("price", productPriceList.get(0).getText().trim());
		productInfoMap.put("exTaxPrice", productPriceList.get(1).getText().split(":")[1].trim());

		return productInfoMap;

	}

	public void selectQuantity(String qty) {
		elementUtil.doSendKeys(quantity, qty);
	}

//	public boolean addToCart() {
//		driver.findElement(addToCartButton).click();
//		String txt = driver.findElement(successmsg).getText();
//		if(txt.contains("Success: You have added  to your shopping cart")) {
//			System.out.println("product added successfully...");
//			return true;
//		}
//		return false;
//		}
		
	public void addToCart() {
		elementUtil.doClick(addToCartButton);
	}
	public boolean clickOnCart() {
		elementUtil.doClick(cart);
		return true;
		 
	}

	public int getProductImages() {
		int imagesCount = elementUtil.getElements(productImages).size();
		System.out.println("Total images : " + imagesCount);
		return imagesCount;
	}

	public String getProductInfoPageTitle(String productname) {
		return elementUtil.waitForTitlePresent(productname, 5);	
	}
	public Shoppingcartpage clickonViewCart() {
		elementUtil.doClick(viewCart);
		return new Shoppingcartpage(driver);
	}

	
	
}
