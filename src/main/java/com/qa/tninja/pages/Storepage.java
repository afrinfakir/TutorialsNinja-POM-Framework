package com.qa.tninja.pages;

import org.openqa.selenium.WebDriver;

public class Storepage {
	
	private WebDriver driver;

	public Storepage(WebDriver driver) {

		this.driver = driver;
	}
	public void store() {
		System.out.println("store page ");
	}
}
