package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.appium.utils.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage  {
	AppiumDriver<MobileElement> driver;

	@AndroidFindBy(id = "org.wordpress.android:id/nux_username")
	public WebElement userNameInput;

	@AndroidFindBy(id = "org.wordpress.android:id/nux_password")
	public WebElement passwordInput;

	@AndroidFindBy(id="org.wordpress.android:id/nux_create_account_button")
	public WebElement createAccountButton;

	@AndroidFindBy(id="org.wordpress.android:id/nux_sign_in_button")
	public WebElement nextButton;

	@AndroidFindBy(id = "org.wordpress.android:id/password_layout")
	public WebElement passwordLayout;

	@AndroidFindBy(id = "org.wordpress.android:id/nux_dialog_title")
	public WebElement loginValidationMessage;
    
	 private static Logger log = Logger.getLogger(LoginPage.class.getClass());
	
	public LoginPage(AppiumDriver<MobileElement> driver)  {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	public void signIn(String UserName,String Password) throws InterruptedException {
		enterUserName(UserName);
		nextButton.click();
		enterPassword(Password);
		nextButton.click();
		Thread.sleep(2000);
		
	}
	public void enterUserName(String UserName) {
		Assert.assertTrue(userNameInput.isDisplayed());
		userNameInput.clear();
		Utility.enterText(userNameInput, UserName);
		log.info("Enterd UserName");
	}

	public void enterPassword(String Password) {
		Assert.assertTrue(passwordInput.isDisplayed());
		passwordInput.clear();
		Utility.enterText(passwordInput, Password);
		log.info("Enterd Password");
	}
}
