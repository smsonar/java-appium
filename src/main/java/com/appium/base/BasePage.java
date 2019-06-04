package com.appium.base;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	public  AppiumDriver mobileDriver;
	Properties property ;

	public BasePage(AppiumDriver<?> driver)  {
		this.mobileDriver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this );
	}
	
}



