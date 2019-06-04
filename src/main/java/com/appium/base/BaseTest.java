package com.appium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.utils.EventHandler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	//private static AndroidDriver<MobileElement> mobileDriver;
	private static WebDriver driver;
	private static AppiumDriver<MobileElement> mobileDriver;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	public static Properties property = new Properties();
    private EventHandler handle;

	//This method will read property file and initialize the driver

	@BeforeClass
	public void setup () throws IOException, InterruptedException {
		getPropertyFile(); 
		driverIntilization();
	}

	//This method will be closing all browser 

	@AfterClass
	public void quitBrowser() {
		if(mobileDriver!=null)
			mobileDriver.quit();
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return mobileDriver;
	}

	public void getPropertyFile() throws IOException {
		property = new Properties();
		FileInputStream inputPropertyFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/appium/config/Config.property");
		property.load(inputPropertyFile);
	}

	//This method is used to initialize the driver according to the driver mentioned in configuration file.

	public void  driverIntilization() throws MalformedURLException, InterruptedException {

		String browserName=property.getProperty("browser");

		if (browserName.equalsIgnoreCase("android")) {
			capabilities.setCapability("deviceName", "Android Emulator");
			capabilities.setCapability("automationName", "UIAutomator2");
			capabilities.setCapability("app", System.getProperty("user.dir")+"/build/wordpress.apk");
			capabilities.setCapability("appPackage", "org.wordpress.android");
			capabilities.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("avd", "Pixel_2_API_28");
			capabilities.setCapability("platformName", "android");
			mobileDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			BaseTest.driver = mobileDriver;
			EventFiringWebDriver eventListnerDriver = new EventFiringWebDriver(driver);
			handle = new EventHandler();
			eventListnerDriver.register(handle);
			Thread.sleep(2000);
		} 

		else if (browserName.equalsIgnoreCase("iOS")) {
			capabilities.setCapability("automationName", "XCuiTest");
			capabilities.setCapability("deviceName", "iPhone 7");
			capabilities.setCapability("platformVersion", "11.1");
			capabilities.setCapability("sendKeyStrategy", "grouped");
			capabilities.setCapability("app", ""); //mobileDriver = new
			mobileDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			Thread.sleep(2000);
		}
		
		else if (browserName.equalsIgnoreCase("web")) {
			
		}
	}
}

