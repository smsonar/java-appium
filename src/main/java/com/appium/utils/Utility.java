package com.appium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.base.BaseTest;

public class Utility extends BaseTest{
	//private static AndroidDriver<MobileElement> driver;
   
	//This method will be used to enter text in given input field
	public  static void enterText(WebElement element,String text) {
		waitUntilDisplayed(element);
		element.sendKeys(text);

	}
    
	//This method will be used for synchronization purpose 
	public static void  waitUntilDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
     
	//This method will be used to click on button
	public static void clickButton(WebElement element){
		waitUntilDisplayed(element);
		element.click();
	}

	public static void waitUntilEnabled(WebElement element) {

	}
}
