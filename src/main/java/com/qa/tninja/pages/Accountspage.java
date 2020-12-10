package com.qa.tninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tninja.utils.Constants;
import com.qa.tninja.utils.ElementUtils;

public class Accountspage {

	private WebDriver driver;
	private ElementUtils elementUtil;

	private By AccountsHeader = By.cssSelector("div#logo a");
	private By searchbox = By.xpath("//input[@type='text' and @name='search']");
	private By searchbutton = By.cssSelector("div#search button[type='button']");
	private By contentList = By.cssSelector("div#content h2");
	private By searchResult = By.cssSelector("div.product-layout .product-thumb");
	private By productsAfterSearch = By.cssSelector(".product-thumb h4 a");

	public Accountspage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(this.driver);
	}

	public String getAccountspageTitle() {
		return elementUtil.waitForTitlePresent(Constants.Accounts_page_title, 10);
	}

	public String getAccountsHeader() {
		return elementUtil.doGetText(AccountsHeader);
	}

	public boolean doSearch(String productname) {
		elementUtil.doSendKeys(searchbox, productname);
		elementUtil.doClick(searchbutton);
		if (elementUtil.getElements(searchResult).size() > 0) {
			return true;
		}
		return false;
	}

	public ProductInfopage clickOnSpecProd(String prod_name) {
		List<WebElement> prod_list = elementUtil.getElements(productsAfterSearch);
		System.out.println(prod_list.size());
		for (WebElement e : prod_list) {
			if (e.getText().equals(prod_name)) {
				e.click();
				break;
			}
		}
		return new ProductInfopage(driver);

	}

	public List<String> getcontentList() {
		List<String> content = new ArrayList<String>();
		List<WebElement> contents = elementUtil.getElements(contentList);
		System.out.println(contents.size());
		for (WebElement e : contents) {
			content.add(e.getText());
		}
		return content;
	}

}
