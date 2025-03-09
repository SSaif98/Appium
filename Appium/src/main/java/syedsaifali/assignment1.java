package syedsaifali;

import java.io.File;
import java.net.*;
import java.util.List;

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

public class assignment1 extends BaseClassTest{

	@Test
	public void assignment1() throws  MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/two_buttons\")")).click();
		
		driver.findElement(By.className("android.widget.ImageView")).isDisplayed();
//		String validText = "Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop.";
//		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/alertTitle\")")).getText(), validText);		
		
		Assert.assertEquals(driver.findElement(By.id("android:id/button2")).getText(), "Cancel");
		Assert.assertEquals(driver.findElement(By.id("android:id/button1")).getText(), "OK");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
		scrollTillTheEnd();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button2\")")).click();
		
//		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
//		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
//		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Command two\"]")).click();
//		Assert.assertEquals(driver.findElement(By.id("android:id/message")).getText(), "You selected: 1 , Command two");
//		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(0)")).click();
//		
//		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		
		driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Map\")")).getText(), "Map");
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")")).getText(), "Satellite");
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")")).getText(), "Traffic");
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Street view\")")).getText(), "Street view");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")")).click();
		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		List<WebElement> list = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
		System.out.println(list.size());
		for(int i=1 ; i<list.size()+1; i++) {
			driver.findElement(By.xpath("(//android.widget.CheckedTextView)["+i+"]")).click();
		}
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
	
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("SaifTest");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("SaifTest");
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/two_buttons_old_school\")")).click();
		driver.findElement(By.className("android.widget.ImageView")).isEnabled();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();

		driver.findElement(By.id("io.appium.android.apis:id/two_buttons_holo_light")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button2\")")).click();
		


	}

}
