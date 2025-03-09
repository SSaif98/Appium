package syedsaifali;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClassTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		//start appium server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//Saif//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//AndroidDriver or IOSDriver
		//Appium Code - > Appium Server -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("saifEmulator"); //emulator
//		options.setApp("C://Users//Saif//eclipse-workspace//Appium//src//main//java//resources//ApiDemos-debug.apk");
		options.setApp("C://Users//Saif//eclipse-workspace//Appium//src//main//java//resources//General-Store.apk");

//		options.setChromedriverExecutable("D://Automation//Appium//chromedriver-win32//chromedriver.exe");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void closeServer() {
		driver.quit();
//		stop appium server
		service.stop();
	}
	
	public void longClickGesture(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration", 2000));
	}
	
	public void scrollTillTheEnd() {
		boolean canScrollMore;
		do {
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 1.0
					)); 
		}while(canScrollMore);
	}
	
	public void direction(WebElement firstImage, String action) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
				"elementId", ((RemoteWebElement)firstImage).getId(),
			    "direction", action,
			    "percent", 0.75
			));
	}
}
