package com.appium.testcase;

import org.testng.annotations.Test;

import com.appium.base.BaseTest;
import com.appium.pages.LoginPage;

public class LoginTest extends BaseTest{


	LoginPage loginpage ;

	@Test
	public void verify_loginfunctionality_for_valid_credentials() throws InterruptedException {
		loginpage= new LoginPage(getDriver());
		loginpage.signIn(property.getProperty("username"), property.getProperty("password"));
	}
}
