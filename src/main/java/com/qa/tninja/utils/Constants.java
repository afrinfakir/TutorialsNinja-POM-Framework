package com.qa.tninja.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String Login_page_title = "Account Login";
	public static final String Accounts_page_title = "My Account";
	public static final String Accounts_header = "Your Store";
	public static final String ACCOUNT_SUCCESS_MESSG = "Your Account Has Been Created";
	public static final String REGISTER_SHEET_NAME = "registration";
	public static final String shoppingcart_page_title = "Shopping Cart";
	
	public static List<String> getcontentList() {
		List<String> cont = new ArrayList<String>();
		cont.add("My Account");
		cont.add("My Orders");
		cont.add("My Affiliate Account");
		cont.add("Newsletter");
		return cont;
	}
	
	

}
