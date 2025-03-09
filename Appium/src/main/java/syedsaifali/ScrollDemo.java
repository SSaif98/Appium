package syedsaifali;

import java.io.File;
import java.net.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollDemo extends BaseClassTest{

	@Test
	public void ScrollDemo() throws  MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Google engine script - androidUIAutomator
				//to scroll: UiScrollable is a class we have to create an obj (new UiSelector). Then there is a method called scrollIntoView
		//When you know where to scroll 
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"
				));

		//When you just need to scroll that it. No prior idea where to scroll
//		scrollTillTheEnd();

		
		Thread.sleep(2000);
	}

}
