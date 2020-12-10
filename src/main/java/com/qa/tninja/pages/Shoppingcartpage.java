package com.qa.tninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.tninja.base.basepage;
import com.qa.tninja.utils.Constants;
import com.qa.tninja.utils.ElementUtils;

public class Shoppingcartpage extends basepage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	private By prod_info_macbookPro = By.xpath("//a[text()='MacBook Pro']//parent::td//following-sibling::td");
	private By prod_info_imac = By.xpath("//a[text()='iMac']//parent::td//following-sibling::td");
	private By coupon = By.linkText("Use Coupon Code");
	private By coupon_text = By.xpath("//input[@id='input-coupon']");
	private By coupon_button = By.xpath("//input[@id='button-coupon']");
	private By estimate_taxes = By.xpath("//a[text()='Estimate Shipping & Taxes ']");
	private By country = By.cssSelector("#input-country");
	private By state = By.cssSelector("#input-zone");
	private By postalcode = By.cssSelector("#input-postcode");
	private By getquote = By.xpath("//button[@id='button-quote']");
	private By giftcode = By.cssSelector("#input-voucher");
	private By gcodeBtn = By.xpath("//input[@id='button-voucher']");
	private By giftlink = By.xpath("//a[contains(text(),'Use Gift Certificate ')]");
	private By subtotal = By.xpath("//strong[text()='Sub-Total:']//parent::td//following-sibling::td");
	private By total = By.xpath("//strong[text()='Total:']//parent::td//following-sibling::td");
	private By continueShopping = By.xpath("//a[text()='Continue Shopping']");
	private By checkout = By.xpath("//a[text()='Checkout']");
	
	public Shoppingcartpage (WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(this.driver);
	}
	
	public boolean Clickoncheckout() {
		elementutils.doClick(checkout);
		return true;
	}
	public Storepage continueShopping() {
		elementutils.doClick(continueShopping);
		return new Storepage(driver);
	}
	public void totalPrice() {
		String sub_total = elementutils.doGetText(subtotal);
		String total_price = elementutils.doGetText(total);
		System.out.println("Sub_total is:"+sub_total);
		System.out.println("Total is :"+total_price);
	}
	public boolean UseGiftCode(String gcode) {
		elementutils.doClick(giftlink);
		elementutils.doSendKeys(giftcode, gcode);
		elementutils.doClick(gcodeBtn);
		return true;
	}
	
	public boolean selectShippingDestination(String countryname,String value,String code) {
		elementutils.clickWhenReady(estimate_taxes, 5);
		elementutils.doSelectDropDownByVisibleText(country, countryname);
		elementutils.doSelectDropDownByVisibleText(state, value);
		elementutils.doSendKeys(postalcode, code);
		elementutils.waitForElementToBeLocated(getquote, 5);
		//elementutils.doClick(getquote);
		//elementutils.waitForAlertToBePresent(5);
		// driver.switchTo().alert().dismiss();
//		System.out.println(alert.getText());
//		alert.dismiss();
		return true;
	}
	
	public List<WebElement> getproductInfo_MacBookPro() {
		List<WebElement> prodinfo =elementutils.getElements(prod_info_macbookPro);
		System.out.println(prodinfo.size());
		for(int i=1 ; i<prodinfo.size();i++) {
			String info =prodinfo.get(i).getText();
			System.out.println("prod_info : "+info);
		}
		return prodinfo;
	}
	public boolean UseCouponCode(String couponcode) {
		elementutils.doClick(coupon);
		elementutils.doSendKeys(coupon_text, couponcode);
		elementutils.doClick(coupon_button);
		return true;
	}
	public String getTitleshoppingpage() {
		return elementutils.waitForTitlePresent(Constants.shoppingcart_page_title, 10);
	}

}
